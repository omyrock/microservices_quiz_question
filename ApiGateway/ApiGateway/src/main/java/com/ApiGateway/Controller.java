package com.ApiGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiGateway")
public class Controller {
    @GetMapping("/test")
    public String getStringTest(){
        return "text Controller";
    }
}
