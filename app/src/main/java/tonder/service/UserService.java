package tonder.service;

import tonder.dto.user.CreateUserDto;
import tonder.dto.user.UserDto;
import tonder.entity.User;

import java.util.List;

public interface UserService {
    void createUser(CreateUserDto createUserDto);

    User findUserById(Integer userId);

    List<UserDto> getAllUsers();
}
