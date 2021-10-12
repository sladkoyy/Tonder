package tonder.controller;

import org.springframework.web.bind.annotation.*;
import tonder.dto.profile.ProfileDto;
import tonder.service.impl.JpaProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    JpaProfileService jpaProfileService;

    public ProfileController(JpaProfileService jpaProfileService) {
        this.jpaProfileService = jpaProfileService;
    }

    @GetMapping("/get-all")
    public List<ProfileDto> getAllProfiles() {
        return jpaProfileService.getAllProfiles();
    }

    @GetMapping("/get/{id}")
    public ProfileDto getProfileById(@PathVariable(value = "id") Integer id) {
        return jpaProfileService.getProfileById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable(value = "id") Integer id) {
        jpaProfileService.deleteProfile(id);
    }
}
