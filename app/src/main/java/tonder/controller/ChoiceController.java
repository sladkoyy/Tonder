package tonder.controller;

import org.springframework.web.bind.annotation.*;
import tonder.dto.choice.ChoiceDto;
import tonder.dto.choice.CreateChoiceDto;
import tonder.service.impl.JpaChoiceService;

import java.util.List;

@RestController
@RequestMapping("/choice")
public class ChoiceController {

    JpaChoiceService jpaChoiceService;

    public ChoiceController(JpaChoiceService jpaChoiceService) {
        this.jpaChoiceService = jpaChoiceService;
    }

    @GetMapping("/get-all")
    List<ChoiceDto> getAllChoices() {
        return jpaChoiceService.getAllChoices();
    }

    @PostMapping("/add-choice")
    public ChoiceDto addUserChoice(@RequestBody CreateChoiceDto createChoiceDto) {
        return jpaChoiceService.addUserChoice(createChoiceDto);
    }
}
