package tonder.service.mapper;

import org.springframework.stereotype.Component;
import tonder.dto.choice.ChoiceDto;
import tonder.entity.Choice;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChoiceMapper {

    public ChoiceDto mapChoiceToChoiceDto(Choice model) {
        return new ChoiceDto(
                model.getId(),
                model.getProfileId(),
                model.getChoice(),
                model.getUser().getId(),
                model.getCreatedAt()
        );
    }

    public List<ChoiceDto> mapChoiceToChoiceDto(Collection<Choice> model) {
        return model.stream()
                .map(this::mapChoiceToChoiceDto)
                .collect(Collectors.toList());
    }
}
