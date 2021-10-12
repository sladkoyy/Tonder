package tonder.service;

import tonder.dto.choice.ChoiceDto;
import tonder.dto.choice.CreateChoiceDto;

import java.util.List;

public interface ChoiceService {
    ChoiceDto addUserChoice(CreateChoiceDto createChoiceDto);

    List<ChoiceDto> getAllChoices();
}
