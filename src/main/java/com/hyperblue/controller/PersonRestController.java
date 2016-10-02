package com.hyperblue.controller;

import com.hyperblue.domain.Person;
import com.hyperblue.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * REST class to manage people
 */
@RestController
@RequestMapping("/person")
public class PersonRestController {

    /**
     * Person Repository
     */
    @Autowired
    private PersonRepository repo;

    /**
     * Get the person
     * @param id the id of the  person
     * @return the person found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Person get(@PathVariable long id) {
        return repo.findOne(id);
    }

    /**
     * Get all the people
     * @return the people found
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method= RequestMethod.GET)
    public Collection<Person> get() {
        return repo.findAll();
    }

    /**
     * Create a new person
     * @param person the person details
     * @return the new person created
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return repo.save(person);
    }

    /**
     * Delete the person
     * @param id the id of the person to delete
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable long id) {
        repo.delete(id);
    }

    /**
     * Update the person
     * @param id id of the person
     * @param person the person details
     * @return the person updated
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) {
        Person update = repo.findOne(id);
        update.setFirstName(person.getFirstName());
        update.setLastName(person.getLastName());
        return repo.save(update);
    }
}