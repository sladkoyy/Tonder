package tonder.controller;

import org.springframework.web.bind.annotation.*;
import tonder.dto.CreateFormDto;
import tonder.dto.FormDto;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    @GetMapping("/get-all-forms")
    public List<FormDto> getAllForms() {
        return List.of(
                new FormDto(
                        1,
                        "Dima",
                        20,
                        "Sooome info!"
                )
        );
    }

    @GetMapping("/get-form/{id}")
    public FormDto getForm (@RequestParam(value = "id") Integer id) {
        return new FormDto(
             id,
            "Test name",
            10,
            "Test info"
        );
    }

    @PostMapping("/create-form")
    public CreateFormDto createForm() {
        return new CreateFormDto(
                "Test name",
                15,
                "Test info"
        );
    }

    @DeleteMapping("/delete-form")
    public void deleteForm(@RequestParam(value = "id") Integer id) {
        //todo удалить анкету из БД
    }
}
