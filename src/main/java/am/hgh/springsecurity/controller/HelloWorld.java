package am.hgh.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorld {

    @GetMapping("/hello")
    public String getHello(Authentication authentication) {
        log.info("Get method {}", authentication.getName());
        return "Hello World. \n";
    }
    @GetMapping("/valiko")
    public String getValiko() {
        return "Hello valiko. \n";
    }
}
