package tonder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FormDto {

    final private Integer   id;
    final private String    name;
    final private Integer   age;
    final private String    info;
}
