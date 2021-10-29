package tonder.service.mapper;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import tonder.dto.choice.ChoiceDto;
import tonder.dto.profile.ProfileDto;
import tonder.entity.Choice;
import tonder.entity.Profile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileMapper {

    private final ChoiceMapper choiceMapper;

    public ProfileMapper(ChoiceMapper choiceMapper) {
        this.choiceMapper = choiceMapper;
    }

    public ProfileDto mapProfileToProfileDto(Profile model) {
        if (model == null)
            return null;
        return new ProfileDto(
                model.getId(),
                choiceMapper.mapChoiceToChoiceDto(model.getChoices()),
                model.getFirstName(),
                model.getLastName(),
                model.getAge(),
                model.getGender(),
                model.getInfo()
        );
    }

    public List<ProfileDto> mapProfileToProfileDto(Collection<Profile> model) {
        if (model == null)
            return null;
        return model.stream()
                .map(this::mapProfileToProfileDto)
                .collect(Collectors.toList());
    }
}
