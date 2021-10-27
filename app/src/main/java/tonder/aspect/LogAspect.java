package tonder.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tonder.annotation.Loggable;
import tonder.service.context.UserContext;

@Aspect
@Component
@Order(2)
public class LogAspect {

    private final UserContext userContext;

    public LogAspect(UserContext userContext) {
        this.userContext = userContext;
    }

    @After("@annotation(loggable)")
    public void loggable(JoinPoint joinPoint, Loggable loggable) {
        String email = userContext.getUsername();
        Boolean isAdmin = userContext.isAdmin();

        System.out.printf(
                "[USERNAME]: %s, isAdmin: %s, methodName: %s",
                email, isAdmin, joinPoint.getSignature().getName()
        );
    }
}