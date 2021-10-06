package tonder.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tonder.dto.choice.ChoiceDto;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private final Integer           id;
    private final String            username;
    private final String            password;
    private final List<ChoiceDto>   choiceList;
    private final Instant           createdAt;
}
