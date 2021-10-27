package tonder.service.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tonder.dto.authentication.UserAuthenticationInfoDto;
import tonder.service.UserService;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private static final String EX_MSG_TMPL_USER_NOT_FOUND = "[email = %s] Пользователь не найден";

    private final UserService userService;

    public JpaUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthenticationInfoDto userInfo = userService.findAuthenticationInfo(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(EX_MSG_TMPL_USER_NOT_FOUND, username)));

        return User.builder()
                .username(userInfo.getEmail())
                .password(userInfo.getPassword())
                .roles(userInfo.getRoleCodes().toArray(new String[0]))
                .build();
    }
}
