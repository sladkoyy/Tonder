package tonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tonder.dto.profile.CreateProfileDto;
import tonder.dto.profile.ProfileDto;
import tonder.service.impl.JpaProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    JpaProfileService jpaProfileService;

    @GetMapping("/get-all")
    public List<ProfileDto> getAllProfiles() {
        return jpaProfileService.getAllProfiles();
    }

    @GetMapping("/get/{id}")
    public ProfileDto getProfileById(@PathVariable(value = "id") Integer id) {
        return jpaProfileService.getProfileById(id);
    }

    @PostMapping("/create")
    public void createProfile(@RequestBody CreateProfileDto createProfileDto) {
        jpaProfileService.createProfile(createProfileDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable(value = "id") Integer id) {
        //todo удалить анкету из БД
    }
}
