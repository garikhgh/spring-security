package am.hgh.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorld {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World. \n";
    }
    @GetMapping("/valiko")
    public String getValiko() {
        return "Hello valiko. \n";
    }
}
