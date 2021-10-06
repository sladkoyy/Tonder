package tonder.controller;

import org.springframework.web.bind.annotation.*;
import tonder.dto.form.CreateProfileDto;
import tonder.dto.form.ProfileDto;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping("/get-all")
    public List<ProfileDto> getAllProfiles() {
        return null;
    }

    @GetMapping("/get/{id}")
    public ProfileDto getProfileById(@PathVariable(value = "id") Integer id) {
        return null;
    }

    @PostMapping("/create-profile")
    public void createProfile(@RequestBody CreateProfileDto createProfileDto) {

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable(value = "id") Integer id) {
        //todo удалить анкету из БД
    }
}
