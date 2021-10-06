package tonder.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import tonder.dto.profile.CreateProfileDto;

@Getter
public class CreateUserDto {

    private final String            username;
    private final String            password;
    private final CreateProfileDto  profile;

    public CreateUserDto(@JsonProperty("username") String username,
                         @JsonProperty("password") String password,
                         @JsonProperty("profile") CreateProfileDto profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }
}
