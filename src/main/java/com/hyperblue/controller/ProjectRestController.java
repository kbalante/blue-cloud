package com.hyperblue.controller;

import com.hyperblue.domain.Project;
import com.hyperblue.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST class to manage projects
 */
@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    /**
     * Project Repository
     */
    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Project get(@PathVariable long id) {
        return projectRepository.findOne(id);
    }


}