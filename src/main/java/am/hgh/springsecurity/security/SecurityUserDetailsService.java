package am.hgh.springsecurity.security;

import am.hgh.springsecurity.domain.UserEntity;
import am.hgh.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserService userService;
    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userByUserName = userService.getUseByUserName(username);
        return new SecurityUser(userByUserName);
    }
}
