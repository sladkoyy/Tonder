package tonder.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tonder.dto.profile.ProfileDto;
import tonder.entity.Role;

import java.time.Instant;
import java.util.Set;

@Getter
@AllArgsConstructor
public class UserDto {

    private final Integer           id;
    private final String            username;
    private final String            password;
    private final Set<Role>         roles;
    private final ProfileDto        profile;
    private final Instant           createdAt;
}
