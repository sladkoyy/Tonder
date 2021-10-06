package tonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tonder.dto.choice.CreateChoiceDto;
import tonder.dto.user.CreateUserDto;
import tonder.service.impl.JpaUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    JpaUserService jpaUserService;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        jpaUserService.createUser(createUserDto);
    }

    @PostMapping("/add-choice")
    public void createChoice(@RequestBody CreateChoiceDto createChoiceDto) {
        jpaUserService.addUserChoice(createChoiceDto);
    }
}
