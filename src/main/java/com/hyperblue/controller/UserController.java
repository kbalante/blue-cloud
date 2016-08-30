package com.hyperblue.controller;

import com.hyperblue.domain.Project;
import com.hyperblue.domain.User;
import com.hyperblue.repository.ProjectRepository;
import com.hyperblue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * User Controller: authenticate and register users
 */
@Controller
public class UserController {
    /**
     * User Repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Project Repository
     */
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Registration Form
     * @return the registration form view
     */
    @RequestMapping("/registration")
    public String registrationForm() {
        return "user/registration";
    }

    /**
     * Login Form
     * @return the login form view
     */
    @RequestMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    /**
     * Validate and register if the user if valid
     * @param user user details
     * @param model model
     * @return the registration thank you page
     */
    @RequestMapping(value="/registration-submit", method=RequestMethod.POST)
    public String registrationSubmit(@ModelAttribute User user, Model model) {

        // set the encrypted password
        // replace with proper encryption
        user.setPasswordEncrypted(user.getPassword());

        // save the user only if the email doesn't exist
        if (userRepository.findOneByEmail(user.getEmail())==null) {
            userRepository.save(user);
            System.out.println("saved to the db");
        } else {
            // go back to the registration form with an error
            model.addAttribute("error", "User already exists with that email. Please use another or log in.");
            return "user/registration";
        }

        return "user/registration-thankyou";
    }

    /**
     * Authenticate the user
     * @param user user details
     * @param model model
     * @return the home page if authenticated otherwise go to login page
     */
    @RequestMapping(value="/authenticate", method=RequestMethod.POST)
    public String loginSubmit(@ModelAttribute User user, Model model) {

        // set the encrypted password
        // replace with proper encryption
        user.setPasswordEncrypted(user.getPassword());

        // save the user only if the email doesn't exist
        if (userRepository.findOneByEmailAndPasswordEncrypted(user.getEmail(), user.getPasswordEncrypted())==null) {
            model.addAttribute("error", "Your email and/or password is incorrect.");
            return "user/login";
        }

        Collection<Project> projects = projectRepository.findAll();

        /*for(Project project:projects) {
            Collection<Task> tasks = project.getTasks();
            for(Task task:tasks) {
                System.out.println(project.getName() + " : " + task.getSummary());
            }
        }*/
        model.addAttribute("projects", projects);

        return "home";
    }
}