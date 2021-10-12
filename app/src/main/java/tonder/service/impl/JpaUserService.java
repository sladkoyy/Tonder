package tonder.service.impl;

import org.springframework.stereotype.Service;
import tonder.dto.user.CreateUserDto;
import tonder.dto.user.UserDto;
import tonder.entity.Profile;
import tonder.entity.User;
import tonder.repository.UserRepository;
import tonder.service.UserService;
import tonder.service.factory.UserFactory;
import tonder.service.mapper.UserMapper;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JpaUserService implements UserService {

    UserRepository  userRepository;
    UserFactory     userFactory;
    UserMapper      userMapper;

    JpaProfileService   profileService;

    public JpaUserService(UserRepository userRepository, UserFactory userFactory, UserMapper userMapper, JpaProfileService profileService) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
        this.userMapper = userMapper;
        this.profileService = profileService;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();

        return userMapper.mapUserToUserDto(userList);
    }

    @Override
    public void createUser(CreateUserDto createUserDto) {
        User user = userFactory.build(createUserDto);

        Profile profile = profileService.createProfile(createUserDto.getProfile());
        user.setProfile(profile);

        userRepository.save(user);
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }

}
