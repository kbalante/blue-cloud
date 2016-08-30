package com.hyperblue.controller;

import com.hyperblue.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Project Controller: manage projects
 */
@Controller
public class ProjectController {

    /**
     * Project Repository
     */
    @Autowired
    private ProjectRepository projectRepository;

    /*@RequestMapping("/project/${id}")
    @ResponseBody
    public String listTasks(@PathVariable("id") long id) {

        Project project = projectRepository.findOne(id);
        //model.addAttribute("project", project);

        //return "project/tasks";
        return "home";
    }*/
}