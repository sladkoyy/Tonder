package tonder.dto.choice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter

public class CreateChoiceDto {

    final private Integer   profileId;
    final private Integer   userId;
    final private Boolean   choice;

    public CreateChoiceDto(@JsonProperty("profileId") Integer profileId,
                           @JsonProperty("userId") Integer userId,
                           @JsonProperty("choice") Boolean choice) {
        this.profileId = profileId;
        this.userId = userId;
        this.choice = choice;
    }
}
