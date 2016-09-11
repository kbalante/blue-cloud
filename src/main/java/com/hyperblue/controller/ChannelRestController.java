package com.hyperblue.controller;

import com.hyperblue.domain.Channel;
import com.hyperblue.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * REST class to manage channels
 */
@RestController
@RequestMapping("/channels")
public class ChannelRestController {

    /**
     * Channel Repository
     */
    @Autowired
    private ChannelRepository repo;

    /**
     * Get the channel
     * @param id the id of the  channel
     * @return the channel found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Channel get(@PathVariable long id) {
        return repo.findOne(id);
    }

    /**
     * Get all the channels
     * @return the channels found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET)
    public Collection<Channel> get() {
        return repo.findAll();
    }

    /**
     * Create a new channel
     * @param channel the channel details
     * @return the new channel created
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.POST)
    public Channel create(@RequestBody Channel channel) {
        return repo.save(channel);
    }

    /**
     * Delete the channel
     * @param id the id of the channel to delete
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable long id) {
        repo.delete(id);
    }

    /**
     * Update the channel
     * @param id id of the channel
     * @param channel the channel details
     * @return the channel updated
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Channel update(@PathVariable long id, @RequestBody Channel channel) {
        Channel update = repo.findOne(id);
        update.setName(channel.getName());
        update.setPrivate(channel.getPrivate());
        return repo.save(update);
    }
}