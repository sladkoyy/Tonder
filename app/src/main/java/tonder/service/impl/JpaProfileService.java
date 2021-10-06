package tonder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tonder.dto.profile.CreateProfileDto;
import tonder.dto.profile.ProfileDto;
import tonder.entity.Profile;
import tonder.repository.ProfileRepository;
import tonder.service.ProfileService;
import tonder.service.factory.ProfileFactory;
import tonder.service.mapper.ProfileMapper;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JpaProfileService implements ProfileService {

    ProfileRepository   profileRepository;
    ProfileMapper       profileMapper;
    ProfileFactory      profileFactory;

    @Autowired
    public JpaProfileService(ProfileRepository profileRepository, ProfileMapper profileMapper, ProfileFactory profileFactory) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
        this.profileFactory = profileFactory;
    }

    @Override
    public List<ProfileDto> getAllProfiles() {
        List<Profile> profileList = profileRepository.findAll();

        return profileMapper.mapProfileToProfileDto(profileList);
    }

    @Override
    public ProfileDto getProfileById(Integer id) {
        Profile profile = profileRepository.findById(id).orElseThrow();

        return profileMapper.mapProfileToProfileDto(profile);
    }

    @Override
    public Profile createProfile(CreateProfileDto profileDto) {
        Profile profile = profileFactory.build(profileDto);

        profileRepository.save(profile);
        return profile;
    }

    @Override
    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }
}
