package com.thismichaelcodes.springboot.controllers;

import com.thismichaelcodes.springboot.managers.SayHelloManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SayHelloController {
    @Autowired
    SayHelloManager sayHelloManager;

    @RequestMapping("/v1/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return sayHelloManager.generateGreeting(name);
    }


}
