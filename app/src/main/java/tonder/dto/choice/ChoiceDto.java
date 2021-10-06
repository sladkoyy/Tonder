package tonder.dto.choice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ChoiceDto {

    private final Integer   id;
    private final Integer   profileId;
    private final Boolean   choice;
    private final Integer   userId;
    private final Instant   createdAt;
}
