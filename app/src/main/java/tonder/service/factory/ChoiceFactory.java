package tonder.service.factory;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tonder.dto.choice.CreateChoiceDto;
import tonder.entity.Choice;

@Component
public class ChoiceFactory {

    public Choice build(CreateChoiceDto choiceDto) {
        Choice choice = new Choice();

        BeanUtils.copyProperties(choiceDto, choice);

        return choice;
    }
}
