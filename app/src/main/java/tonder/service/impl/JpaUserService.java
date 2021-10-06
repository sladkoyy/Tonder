package tonder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tonder.dto.choice.CreateChoiceDto;
import tonder.dto.profile.CreateProfileDto;
import tonder.dto.user.CreateUserDto;
import tonder.entity.Choice;
import tonder.entity.Profile;
import tonder.entity.User;
import tonder.repository.UserRepository;
import tonder.service.UserService;
import tonder.service.factory.UserFactory;

import javax.transaction.Transactional;

@Transactional
@Service
public class JpaUserService implements UserService {

    UserRepository  userRepository;
    UserFactory     userFactory;

    @Autowired
    JpaProfileService   profileService;

    @Autowired
    JpaChoiceService    choiceService;

    @Autowired
    public JpaUserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    @Override
    public void createUser(CreateUserDto createUserDto) {
        User user = userFactory.build(createUserDto);

        Profile profile = profileService.createProfile(createUserDto.getProfile());
        user.setProfile(profile);

        userRepository.save(user);
    }

    @Override
    public void addUserChoice(CreateChoiceDto createChoiceDto) {
        User user = userRepository.getById(createChoiceDto.getUserId());

        Choice choice = choiceService.addUserChoice(createChoiceDto);
        user.addChoice(choice);

        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    public void addProfileToUser(Integer userId, CreateProfileDto createProfileDto) {
        User user = userRepository.getById(userId);

        Profile profile = profileService.createProfile(createProfileDto);
        user.setProfile(profile);

        userRepository.save(user);
    }
}
