package tonder.service;

import tonder.dto.choice.ChoiceDto;
import tonder.dto.choice.CreateChoiceDto;
import tonder.entity.Choice;

import java.util.List;

public interface ChoiceService {
    Choice addUserChoice(CreateChoiceDto createChoiceDto);

    List<ChoiceDto> getAllChoices();
}
