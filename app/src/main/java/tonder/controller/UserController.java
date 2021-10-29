package tonder.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tonder.dto.user.CreateUserDto;
import tonder.dto.user.UserDto;
import tonder.dto.user.filter.UserFilterDto;
import tonder.service.UserService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/filter")
    public List<UserDto> getUsersByFilter(@RequestBody Collection<UserFilterDto> filters) {
        return userService.getUsersByFilter(filters);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/{username}/roles")
    public void editRoles(@PathVariable String username,
                          @RequestBody Collection<String> newRoleCodes) {

        userService.editRole(username, newRoleCodes);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        userService.createUser(createUserDto);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{username}/delete")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
}
