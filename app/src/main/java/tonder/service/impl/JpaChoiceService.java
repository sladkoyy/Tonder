package tonder.service.impl;

import org.springframework.stereotype.Service;
import tonder.dto.choice.ChoiceDto;
import tonder.entity.Choice;
import tonder.entity.Profile;
import tonder.entity.User;
import tonder.repository.ChoiceRepository;
import tonder.repository.UserRepository;
import tonder.service.ChoiceService;
import tonder.service.mapper.ChoiceMapper;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JpaChoiceService implements ChoiceService {

    private final ChoiceRepository    choiceRepository;
    private final ChoiceMapper        choiceMapper;

    private final UserRepository      userRepository;

    public JpaChoiceService(ChoiceRepository choiceRepository, ChoiceMapper choiceMapper,
                            UserRepository userRepository) {
        this.choiceRepository = choiceRepository;
        this.choiceMapper = choiceMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<ChoiceDto> getAllChoices() {
        return choiceMapper.mapChoiceToChoiceDto(choiceRepository.findAll());
    }

    @Transactional
    @Override
    public void like(String requester, String adresser) {
        Choice choice = new Choice();

        User reqUser = userRepository.findOneWithRolesByUsername(requester).orElseThrow();
        User adrUser = userRepository.findOneWithRolesByUsername(adresser).orElseThrow();

        choice.setRequester(reqUser.getProfile());
        choice.setAdresser(adrUser.getProfile());

        choiceRepository.save(choice);
    }

    @Override
    public Boolean isLikesYou(String requester, String adresser) {
        Profile req = userRepository.findOneWithRolesByUsername(requester).orElseThrow().getProfile();
        Profile adr = userRepository.findOneWithRolesByUsername(adresser).orElseThrow().getProfile();

        List<Choice> adrChoices = adr.getChoices();

        for (Choice adrChoice : adrChoices) {
            if (adrChoice.getAdresser().getId().equals(req.getId())) {
                return true;
            }
        }
        return false;
    }
}
