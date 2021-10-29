package tonder.service.impl;

import org.springframework.stereotype.Service;
import tonder.dto.profile.CreateProfileDto;
import tonder.dto.profile.EditProfileDto;
import tonder.dto.profile.ProfileDto;
import tonder.entity.Profile;
import tonder.entity.User;
import tonder.repository.ProfileRepository;
import tonder.repository.UserRepository;
import tonder.service.ProfileService;
import tonder.service.context.UserContext;
import tonder.service.factory.ProfileFactory;
import tonder.service.mapper.ProfileMapper;

import javax.transaction.Transactional;
import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class JpaProfileService implements ProfileService {

    private final String              EX_MSG_USER_ACCS_DENI = "Access denied :)";

    private final UserContext         userContext;

    private final ProfileRepository   profileRepository;
    private final ProfileMapper       profileMapper;
    private final ProfileFactory      profileFactory;

    private final UserRepository      userRepository;

    public JpaProfileService(ProfileRepository profileRepository, ProfileMapper profileMapper,
                             ProfileFactory profileFactory, UserRepository userRepository,
                             UserContext userContext) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
        this.profileFactory = profileFactory;
        this.userRepository = userRepository;
        this.userContext = userContext;
    }

    @Override
    public List<ProfileDto> getAllProfiles() {
        List<Profile> profileList = profileRepository.findAll();

        return profileMapper.mapProfileToProfileDto(profileList);
    }

    @Override
    public ProfileDto getProfileById(String username) {
        Profile profile = userRepository.findOneWithRolesByUsername(username).orElseThrow().getProfile();

        return profileMapper.mapProfileToProfileDto(profile);
    }

    @Transactional
    @Override
    public ProfileDto createProfile(CreateProfileDto profileDto, String username) throws AccessDeniedException {
        String authUsername = userContext.getUsername();
        Boolean isAdmin = userContext.isAdmin();
        if (!authUsername.equals(username) && !isAdmin)
            throw new AccessDeniedException(EX_MSG_USER_ACCS_DENI);

        User user = userRepository.findOneWithRolesByUsername(username).orElseThrow();
        if (user.getProfile() != null)
            return profileMapper.mapProfileToProfileDto(user.getProfile());

        Profile profile = profileFactory.build(profileDto);
        profileRepository.save(profile);

        user.setProfile(profile);
        userRepository.save(user);

        return profileMapper.mapProfileToProfileDto(profile);
    }

    @Transactional
    @Override
    public void deleteProfile(String username) throws AccessDeniedException {
        String authUsername = userContext.getUsername();
        Boolean isAdmin = userContext.isAdmin();

        User user = userRepository.findOneWithRolesByUsername(authUsername).orElseThrow();
        Integer profileId = user.getProfile().getId();

        if (!authUsername.equals(username) && !isAdmin)
            throw new AccessDeniedException(EX_MSG_USER_ACCS_DENI);
        user.setProfile(null);
        profileRepository.deleteById(profileId);
    }

    @Transactional
    @Override
    public ProfileDto editProfile(String username, EditProfileDto profileEditDto) throws AccessDeniedException {
        String authUsername = userContext.getUsername();
        Boolean isAdmin = userContext.isAdmin();

        if (!authUsername.equals(username) && !isAdmin)
            throw new AccessDeniedException(EX_MSG_USER_ACCS_DENI);

        User user = userRepository.findOneWithRolesByUsername(authUsername).orElseThrow();
        Profile profile = profileRepository.findById(user.getProfile().getId()).orElseThrow();

        profile.setFirstName(profileEditDto.getFirstName());
        profile.setLastName(profileEditDto.getLastName());
        profile.setGender(profileEditDto.getGender());
        profile.setAge(profileEditDto.getAge());
        profile.setInfo(profileEditDto.getInfo());

        profileRepository.save(profile);

        return profileMapper.mapProfileToProfileDto(profile);
    }
}
