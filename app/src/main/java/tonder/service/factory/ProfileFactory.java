package tonder.service.factory;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tonder.dto.profile.CreateProfileDto;
import tonder.entity.Profile;

@Component
public class ProfileFactory {

    public Profile build(CreateProfileDto profileDto) {
        Profile profile = new Profile();

        BeanUtils.copyProperties(profileDto, profile);

        return profile;
    }
}
