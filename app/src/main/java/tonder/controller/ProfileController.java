package tonder.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tonder.dto.choice.ChoiceDto;
import tonder.dto.profile.CreateProfileDto;
import tonder.dto.profile.EditProfileDto;
import tonder.dto.profile.ProfileDto;
import tonder.service.ProfileService;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/user/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/all")
    public List<ProfileDto> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{username}")
    public ProfileDto getProfile(@PathVariable String username) {
        return profileService.getProfileById(username);
    }

    @PostMapping("/{username}/create")
    public ProfileDto createProfile(@RequestBody CreateProfileDto profileDto,
                                    @PathVariable String username) throws AccessDeniedException {
        SecurityContextHolder.getContext().getAuthentication().getName();
        return profileService.createProfile(profileDto, username);
    }

    @PutMapping("/{username}/update")
    public ProfileDto editProfile(@PathVariable String username,
                                  @RequestBody EditProfileDto editProfileDto) throws AccessDeniedException {
        return profileService.editProfile(username, editProfileDto);
    }

    @DeleteMapping("/{username}/delete")
    public void deleteProfile(@PathVariable String username) throws AccessDeniedException {
        profileService.deleteProfile(username);
    }
}
