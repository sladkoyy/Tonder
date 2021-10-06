package tonder.service.mapper;

import org.springframework.stereotype.Component;
import tonder.dto.profile.ProfileDto;
import tonder.entity.Profile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileMapper {

    public ProfileDto mapProfileToProfileDto(Profile model) {
        return new ProfileDto(
                model.getId(),
                model.getFirstName(),
                model.getLastName(),
                model.getAge(),
                model.getGender(),
                model.getInfo(),
                model.getCreatedAt()
        );
    }

    public List<ProfileDto> mapProfileToProfileDto(Collection<Profile> model) {
        return model.stream()
                .map(this::mapProfileToProfileDto)
                .collect(Collectors.toList());
    }
}
