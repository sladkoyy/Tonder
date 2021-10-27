package tonder.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateUserDto {

    private final String            username;
    private final String            password;

    public CreateUserDto(@JsonProperty("username") String username,
                         @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }
}
