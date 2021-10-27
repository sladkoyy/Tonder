package tonder.service;

import tonder.dto.authentication.UserAuthenticationInfoDto;
import tonder.dto.user.CreateUserDto;
import tonder.dto.user.UserDto;
import tonder.dto.user.filter.UserFilterDto;
import tonder.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(CreateUserDto createUserDto);

    List<UserDto> getAllUsers();

    List<UserDto> getUsersByFilter(Collection<UserFilterDto> filters);

    Optional<UserAuthenticationInfoDto> findAuthenticationInfo(String email);

    void editRole(String username, Collection<String> newRoleCodes);

    void deleteUser(String username);
}
