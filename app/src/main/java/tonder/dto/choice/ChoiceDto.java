package tonder.dto.choice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChoiceDto {

    private final Integer      id;
    private final String       requester;
    private final String       addressee;
}
