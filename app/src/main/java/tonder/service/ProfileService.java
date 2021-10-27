package tonder.service;

import tonder.dto.profile.CreateProfileDto;
import tonder.dto.profile.EditProfileDto;
import tonder.dto.profile.ProfileDto;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface ProfileService {

    List<ProfileDto> getAllProfiles();

    ProfileDto getProfileById(String username);

    ProfileDto createProfile(CreateProfileDto profileDto, String username) throws AccessDeniedException;

    void deleteProfile(String username) throws AccessDeniedException;

    ProfileDto editProfile(String username, EditProfileDto profileEditDto) throws AccessDeniedException;
}
