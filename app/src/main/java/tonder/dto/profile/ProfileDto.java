package tonder.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ProfileDto {

    final private Integer   id;
    final private String    firstName;
    final private String    lastName;
    final private Integer   age;
    final private Character gender;
    final private String    info;
    final private Instant   createdAt;
}
