package tonder.service;

import tonder.dto.choice.ChoiceDto;

import java.util.List;

public interface ChoiceService {

    List<ChoiceDto> getAllChoices();

    Boolean isLikesYou(String requester, String adresser);

    void like(String requester, String adresser);
}