package tonder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateFormDto {

    final private String    name;
    final private Integer   age;
    final private String    info;
}
