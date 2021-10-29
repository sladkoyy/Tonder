package tonder.dto.choice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateChoiceDto {

    final private String   requesterId;
    final private String   adresserId;

    public CreateChoiceDto(@JsonProperty("requesterId") String requesterId,
                           @JsonProperty("adresserId") String adresserId) {
        this.requesterId = requesterId;
        this.adresserId = adresserId;
    }
}
