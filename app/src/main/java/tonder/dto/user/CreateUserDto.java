package tonder.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CreateUserDto {

    private final String    username;
    private final String    password;
    private final Instant   createdAt;
}
