package tonder.dto.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateProfileDto {

    final private String    firstName;
    final private String    lastName;
    final private Integer   age;
    final private Character gender;
    final private String    info;

    public CreateProfileDto(@JsonProperty("firstName") String firstName,
                            @JsonProperty("lastName") String lastName,
                            @JsonProperty("age")Integer age,
                            @JsonProperty("gender")Character gender,
                            @JsonProperty("info") String info) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.info = info;
    }
}
