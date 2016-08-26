package com.hyperblue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Hello there");
        return "index";
    }
}
