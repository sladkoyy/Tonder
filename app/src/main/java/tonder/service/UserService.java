package tonder.service;

import tonder.dto.choice.CreateChoiceDto;
import tonder.dto.profile.CreateProfileDto;
import tonder.dto.user.CreateUserDto;
import tonder.entity.User;

public interface UserService {
    void createUser(CreateUserDto createUserDto);

    void addUserChoice(CreateChoiceDto createChoiceDto);

    User getUserById(Integer userId);

    void addProfileToUser(Integer userId, CreateProfileDto createProfileDto);
}
