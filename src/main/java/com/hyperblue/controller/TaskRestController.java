package com.hyperblue.controller;

import com.hyperblue.domain.Task;
import com.hyperblue.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private TaskRepository taskRepository;

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Task get(@PathVariable long id) {
        System.out.println("hello");
        return taskRepository.findOne(id);
    }


}