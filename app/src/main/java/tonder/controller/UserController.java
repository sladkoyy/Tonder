package tonder.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tonder.dto.user.CreateUserDto;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/create-user")
    public void createUser(@RequestBody CreateUserDto createUserDto) {

    }
}
