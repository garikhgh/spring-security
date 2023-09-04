package am.hgh.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/users")
    public String getHello(Authentication authentication) {
        log.info("Get method {}", authentication.getName());
        return "Hello World. \n";
    }
    @GetMapping("/valiko")
    public String getValiko(Principal principal) {
        log.info("The longed user is {}", principal.getName());
        return "Hello valiko. \n";
    }
}
