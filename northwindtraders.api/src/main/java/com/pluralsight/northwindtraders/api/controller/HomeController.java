package com.pluralsight.northwindtraders.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "world1") String country){
        return "Hello " + country;
    }
}
