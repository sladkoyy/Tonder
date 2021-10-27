package tonder.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tonder.entity.Role;
import tonder.entity.User;
import tonder.service.context.UserContext;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
@Order(1)
public class UserContextAspect {

    private final UserContext userContext;

    public UserContextAspect(UserContext userContext) {
        this.userContext = userContext;
    }

    @Before("execution(public * *(..)) " +
            "&& within(@org.springframework.web.bind.annotation.RestController *)")
    public void setUserContext() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        Boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_admin"));
        userContext.setUsername(username);
        userContext.setIsAdmin(isAdmin);
    }
}