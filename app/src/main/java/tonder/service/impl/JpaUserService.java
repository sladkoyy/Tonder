package tonder.service.impl;

import org.springframework.stereotype.Service;
import tonder.dto.authentication.UserAuthenticationInfoDto;
import tonder.dto.user.CreateUserDto;
import tonder.dto.user.UserDto;
import tonder.dto.user.filter.UserFilterDto;
import tonder.entity.Profile;
import tonder.entity.Role;
import tonder.entity.User;
import tonder.repository.ProfileRepository;
import tonder.repository.RoleRepository;
import tonder.repository.UserRepository;
import tonder.repository.specification.UserSpecification;
import tonder.service.UserService;
import tonder.service.factory.UserFactory;
import tonder.service.mapper.UserMapper;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JpaUserService implements UserService {

    private final RoleRepository      roleRepository;
    private final ProfileRepository   profileRepository;
    private final UserRepository      userRepository;
    private final UserFactory         userFactory;
    private final UserMapper          userMapper;

    public JpaUserService(RoleRepository roleRepository, ProfileRepository profileRepository,
                          UserRepository userRepository, UserFactory userFactory,
                          UserMapper userMapper) {
        this.roleRepository = roleRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.userFactory = userFactory;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();

        return userMapper.mapUserToUserDto(userList);
    }

    @Transactional
    @Override
    public void createUser(CreateUserDto createUserDto) {
        User user = userFactory.build(createUserDto);

        Set<Role> roles = roleRepository.findAllByCodeIn(Collections.singleton("user"));
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public List<UserDto> getUsersByFilter(Collection<UserFilterDto> filters) {
        List<User> users = userRepository.findAll(UserSpecification.findUsers(filters));
        return userMapper.mapUserToUserDto(users);
    }

    @Override
    public Optional<UserAuthenticationInfoDto> findAuthenticationInfo(String username) {
        Optional<User> userOpt = userRepository.findOneWithRolesByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return Optional.of(new UserAuthenticationInfoDto(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getRoles().stream().map(Role::getCode).collect(Collectors.toSet())
            ));
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public void editRole(String username, Collection<String> newRoleCodes) {
        Integer userId = userRepository.findOneByUsername(username).getId();
        User user = userRepository.getById(userId);

        Set<Role> newRoles = roleRepository.findAllByCodeIn(newRoleCodes);
        user.setRoles(newRoles);

        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(String username) {
        User user = userRepository.findOneWithRolesByUsername(username).orElseThrow();
        Integer userId = user.getId();

        if (user.getProfile() != null) {
            Profile profile = user.getProfile();
            profile.setUser(null);
            profileRepository.save(profile);
        }

        userRepository.deleteById(userId);
    }
}
