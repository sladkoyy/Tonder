package tonder.service.context.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import tonder.entity.Role;
import tonder.service.context.UserContext;

import java.util.Set;

@Component
@RequestScope
@Getter
@Setter
public class UserContextImpl implements UserContext {

    private String    username = null;

    private Boolean   isAdmin = false;

    @Override
    public Boolean isAdmin() {
        return isAdmin;
    }
}
