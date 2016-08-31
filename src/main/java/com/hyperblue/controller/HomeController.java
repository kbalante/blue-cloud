package com.hyperblue.controller;

import com.hyperblue.domain.Project;
import com.hyperblue.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class HomeController {

    /**
     * Project Repository
     */
    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping("/home")
    public String home(Model model) {
        Collection<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "home";
    }
}
