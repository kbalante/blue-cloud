package com.hyperblue.controller;

import com.hyperblue.domain.Project;
import com.hyperblue.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    private ProjectRepository repo;

    /**
     * Get the project
     * @param id the id of the  project
     * @return the project found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Project get(@PathVariable long id) {
        return repo.findOne(id);
    }

    /**
     * Get all the projects
     * @return the projects found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET)
    public Collection<Project> get() {
        return repo.findAll();
    }

    /**
     * Create a new project
     * @param project the project details
     * @return the new project created
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.POST)
    public Project create(@RequestBody Project project) {
        return repo.save(project);
    }

    /**
     * Delete the project
     * @param id the id of the project to delete
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable long id) {
        repo.delete(id);
    }

    /**
     * Update the project
     * @param id id of the project
     * @param project the project details
     * @return the project updated
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Project update(@PathVariable long id, @RequestBody Project project) {
        Project update = repo.findOne(id);
        update.setName(project.getName());
        update.setDescription(project.getDescription());
        update.setPrivate(project.getPrivate());
        return repo.save(update);
    }
}