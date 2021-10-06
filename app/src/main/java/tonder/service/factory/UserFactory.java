package tonder.service.factory;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tonder.dto.user.CreateUserDto;
import tonder.entity.User;

@Component
public class UserFactory {

    public User build(CreateUserDto userDto) {
        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        return user;
    }
}
