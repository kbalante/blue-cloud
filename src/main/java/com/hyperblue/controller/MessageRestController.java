package com.hyperblue.controller;

import com.hyperblue.domain.Message;
import com.hyperblue.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * REST class to manage messages
 */
@RestController
@RequestMapping("/messages")
public class MessageRestController {

    /**
     * Message Repository
     */
    @Autowired
    private MessageRepository repo;

    /**
     * Get the message
     * @param id the id of the  message
     * @return the message found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Message get(@PathVariable long id) {
        return repo.findOne(id);
    }

    /**
     * Get all the messages
     * @return the messages found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET)
    public Collection<Message> get() {
        return repo.findAll();
    }

    /**
     * Create a new message
     * @param message the message details
     * @return the new message created
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.POST)
    public Message create(@RequestBody Message message) {
        return repo.save(message);
    }

    /**
     * Delete the message
     * @param id the id of the message to delete
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable long id) {
        repo.delete(id);
    }

    /**
     * Update the message
     * @param id id of the message
     * @param message the message details
     * @return the message updated
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Message update(@PathVariable long id, @RequestBody Message message) {
        Message update = repo.findOne(id);
        update.setMessage(message.getMessage());
        update.setChannel(message.getChannel());
        return repo.save(update);
    }
}