package am.hgh.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebAuthorizationConfig{

    @Autowired
    private StaticKeyAuthenticationFilter filter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SCryptPasswordEncoder sCryptPasswordEncoder() {
        return new SCryptPasswordEncoder(1638, 8, 1, 32, 64);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable();
        httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
        httpSecurity.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class);
//        httpSecurity.addFilterAt(filter, BasicAuthenticationFilter.class);
        httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(HttpMethod.GET, "/valiko").hasAuthority("USER")
                                .anyRequest().permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/hello").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/valiko").hasRole("ADMIN")
                                .anyRequest().permitAll()
                                .anyRequest()
                                .authenticated()

                );
//                .httpBasic(Customizer.withDefaults());
                httpSecurity.httpBasic(c -> {
                    c.realmName("Valiko");
                    c.authenticationEntryPoint(new CustomEntryPoint());
                });
        return httpSecurity.build();
    }

}
