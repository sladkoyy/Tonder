package tonder.service;

import tonder.dto.profile.CreateProfileDto;
import tonder.dto.profile.ProfileDto;
import tonder.entity.Profile;

import java.util.List;

public interface ProfileService {
    List<ProfileDto> getAllProfiles();

    ProfileDto getProfileById(Integer id);

    Profile createProfile(CreateProfileDto profileDto);

    void deleteProfile(Integer id);
}
