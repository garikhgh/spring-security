package am.hgh.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
public class UserManagementConfig {

    // this is for demonstration.
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("john")
                .password("1234")
                .authorities("read")
                .build();
        userDetailsService.createUser(user);
        return userDetailsService;
    }

}
