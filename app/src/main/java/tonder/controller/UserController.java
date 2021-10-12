package tonder.controller;

import org.springframework.web.bind.annotation.*;
import tonder.dto.user.CreateUserDto;
import tonder.dto.user.UserDto;
import tonder.service.impl.JpaUserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    JpaUserService jpaUserService;

    public UserController(JpaUserService jpaUserService) {
        this.jpaUserService = jpaUserService;
    }

    @GetMapping("/get-all")
    public List<UserDto> getAllProfiles() {
        return jpaUserService.getAllUsers();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        jpaUserService.createUser(createUserDto);
    }
}
