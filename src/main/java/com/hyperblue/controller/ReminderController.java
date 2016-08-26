package com.hyperblue.controller;

import com.hyperblue.domain.Reminder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReminderController {

    /*@RequestMapping("/reminders")
    public String search(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "reminders";
    }*/

    @RequestMapping(value="/task/all", method=RequestMethod.GET)
    public String all(Reminder task) {
        return "tasks";
    }

    @RequestMapping(value="/task/delete", method=RequestMethod.POST)
    public String delete(Reminder task) {
        // customerRepository.delete(task);
        return "reminders";
    }

    @RequestMapping(value="/task/search", method=RequestMethod.POST)
    public String search() {
        // customerRepository.findAll();
        return "reminders";
    }

    /**
     * 1. Review Spring MVC Tutorial and all annotations
     * 2. Fix this class
     * 3. Clean up Application.java
     *
     *
     *
     *
     *
     */


}
