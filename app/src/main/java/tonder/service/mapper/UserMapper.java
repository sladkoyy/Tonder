package tonder.service.mapper;

import org.springframework.stereotype.Component;
import tonder.dto.user.UserDto;
import tonder.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    ChoiceMapper    choiceMapper;
    ProfileMapper   profileMapper;

    public UserMapper(ChoiceMapper choiceMapper, ProfileMapper profileMapper) {
        this.choiceMapper = choiceMapper;
        this.profileMapper = profileMapper;
    }

    public UserDto mapUserToUserDto(User model) {
        return new UserDto(
                model.getId(),
                model.getUsername(),
                model.getPassword(),
                model.getRoles(),
                model.getProfile() == null ? null : profileMapper.mapProfileToProfileDto(model.getProfile()),
                model.getCreatedAt()
        );
    }

    public List<UserDto> mapUserToUserDto(Collection<User> model) {
        return model.stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }
}
