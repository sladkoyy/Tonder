package tonder.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileDto {

    final private Integer   id;
    final private String    firstName;
    final private String    lastName;
    final private Integer   age;
    final private String    info;
}
