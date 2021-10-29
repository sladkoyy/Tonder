package tonder.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tonder.dto.choice.ChoiceDto;
import tonder.service.ChoiceService;

import java.util.List;

@RestController
@RequestMapping("/user/profile/like")
public class ChoiceController {

    private final ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/all")
    public List<ChoiceDto> getAllChoices() {
        return choiceService.getAllChoices();
    }

    @PostMapping("/{requester}/to/{adresser}")
    public void like(@PathVariable String requester,
                     @PathVariable String adresser) {
        choiceService.like(requester, adresser);
    }

    @GetMapping("/{requester}/to/{adresser}")
    public Boolean isLikesYou(@PathVariable String requester,
                              @PathVariable String adresser) {
        return choiceService.isLikesYou(requester, adresser);
    }
}