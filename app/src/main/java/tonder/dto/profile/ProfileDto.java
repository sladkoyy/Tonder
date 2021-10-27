package tonder.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tonder.dto.choice.ChoiceDto;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProfileDto {

    final private Integer           id;
    final private List<ChoiceDto>   choices;
    final private String            firstName;
    final private String            lastName;
    final private Integer           age;
    final private Character         gender;
    final private String            info;
}
