package me.coast.auth.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/say")
    public String sayHello(@RequestParam(required = false) String code){
        System.out.println("code="+code);
        return "auth2.0";
    }

    @GetMapping("/dummy")
    public String dummy(@RequestParam(required = false) String code){
        System.out.println("code="+code);
        return "auth2.0";
    }
}
