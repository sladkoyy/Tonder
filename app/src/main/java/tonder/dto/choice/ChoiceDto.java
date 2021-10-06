package tonder.dto.choice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ChoiceDto {

    private final Integer   id;
    private final String    username;
    private final Instant   createdAt;
}
