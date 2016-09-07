package com.hyperblue.controller;

import com.hyperblue.domain.Task;
import com.hyperblue.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST class to manage tasks
 */
@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    /**
     * Task Repository
     */
    @Autowired
    private TaskRepository repo;

    /**
     * Get the task
     * @param id the id of the task
     * @return the task found
     */
    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Task get(@PathVariable long id) {
        return repo.findOne(id);
    }

    /**
     * Create a new task
     * @param task the task details
     * @return the new task created
     */
    @RequestMapping(method=RequestMethod.POST)
    public Task create(@RequestBody Task task) {
        return repo.save(task);
    }

    /**
     * Delete the task
     * @param id the id of the task to delete
     */
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable long id) {
        repo.delete(id);
    }

    /**
     * Update the task
     * @param id id of the task
     * @param task the task details
     * @return the task updated
     */
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Task update(@PathVariable long id, @RequestBody Task task) {
        Task update = repo.findOne(id);
        update.setSummary(task.getSummary());
        update.setDescription(task.getDescription());
        return repo.save(update);
    }
}