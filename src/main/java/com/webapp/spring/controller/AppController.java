package com.webapp.spring.controller;

import com.webapp.spring.model.Role;
import com.webapp.spring.model.Skill;
import com.webapp.spring.model.Status;
import com.webapp.spring.model.User;
import com.webapp.spring.service.RoleService;
import com.webapp.spring.service.SkillService;
import com.webapp.spring.service.StatusService;
import com.webapp.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    StatusService statusService;

    @Autowired
    SkillService skillService;

    @Autowired
    MessageSource messageSource;

    @Value("${image}")
    private String UPLOAD_LOCATION;

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "userslist";
    }

    /**
     * Method Search
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.POST)
    public String searchUser(@RequestParam(value = "filter") String filter,
                             @RequestParam(value = "search") String text,
                              ModelMap model) {
        List<User> users = userService.searchUser(filter,text);
        model.addAttribute("users", users);
        return "userslist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()){
            return "registration";
        }

        userService.saveUser(user, file);

        model.addAttribute("success", "User " +user.getFirstname()
                            + " " + user.getLastname() + " updated successfully");
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id, ModelMap model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable Integer id,
                             @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()){
            return "registration";
        }

        userService.updateUser(user, file);

        model.addAttribute("success", "User " + user.getFirstname() + " "
                + user.getLastname() + " updated successfully ");
        return "registrationsuccess";
    }

    /**
     * This method will delete an user by it's Id value.
     */
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "redirect:/list";
    }

    /**
     * This method will provide Skill list to views
     */
    @ModelAttribute("skills")
    public List<Skill> initializeSkills(){
        return skillService.findAllSkills();
    }

    /**
     * This method will provide Role list to views
     */
    @ModelAttribute("role")
    public List<Role> initializeRoles(){
        return roleService.findAllRoles();
    }

    /**
     * This method will provide Status list to views
     */
    @ModelAttribute("status")
    public List<Status> initializeStatuses(){
        return statusService.findAllStatus();
    }

}
