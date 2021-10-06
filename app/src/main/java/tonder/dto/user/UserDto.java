package tonder.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class UserDto {

    private final Integer   id;
    private final String    username;
    private final String    password;
    private final Instant   createdAt;
}
