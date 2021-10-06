package tonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tonder.dto.choice.ChoiceDto;
import tonder.service.impl.JpaChoiceService;

import java.util.List;

@RestController
@RequestMapping("/choice")
public class ChoiceController {

    @Autowired
    JpaChoiceService jpaChoiceService;

    @GetMapping("/get-all")
    List<ChoiceDto> getAllChoices() {
        return jpaChoiceService.getAllChoices();
    }
}
