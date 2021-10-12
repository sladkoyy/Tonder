package tonder.service.impl;

import org.springframework.stereotype.Service;
import tonder.dto.choice.ChoiceDto;
import tonder.dto.choice.CreateChoiceDto;
import tonder.entity.Choice;
import tonder.repository.ChoiceRepository;
import tonder.service.ChoiceService;
import tonder.service.UserService;
import tonder.service.factory.ChoiceFactory;
import tonder.service.mapper.ChoiceMapper;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JpaChoiceService implements ChoiceService {

    ChoiceRepository    choiceRepository;
    ChoiceFactory       choiceFactory;
    ChoiceMapper        choiceMapper;

    UserService         userService;

    public JpaChoiceService(ChoiceRepository choiceRepository, ChoiceFactory choiceFactory, ChoiceMapper choiceMapper, UserService userService) {
        this.choiceRepository = choiceRepository;
        this.choiceFactory = choiceFactory;
        this.choiceMapper = choiceMapper;
        this.userService = userService;
    }

    @Override
    public ChoiceDto addUserChoice(CreateChoiceDto createChoiceDto) {
        Choice choice = choiceFactory.build(createChoiceDto);
        Integer userId = createChoiceDto.getUserId();

        choice.setUser(userService.findUserById(userId));
        choiceRepository.saveAndFlush(choice);
        return (choiceMapper.mapChoiceToChoiceDto(choice));
    }

    @Override
    public List<ChoiceDto> getAllChoices() {
        List<Choice> choiceList = choiceRepository.findAll();

        return choiceMapper.mapChoiceToChoiceDto(choiceList);
    }
}
