package com.example.Todoapp.web;


import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @RequestMapping(method= RequestMethod.GET, value = "/welcome")
    public @ResponseBody String sayHello(){
        return "Hi Cengizhan!";
    }
}
