package com.hyperblue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * Load the home page
     * @return the home template
     */
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
