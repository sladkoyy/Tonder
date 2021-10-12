package tonder.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tonder.dto.choice.ChoiceDto;
import tonder.dto.profile.ProfileDto;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private final Integer           id;
    private final String            username;
    private final String            password;
    private final List<ChoiceDto>   choiceList;
    private final ProfileDto        profileDto;
    private final Instant           createdAt;
}
