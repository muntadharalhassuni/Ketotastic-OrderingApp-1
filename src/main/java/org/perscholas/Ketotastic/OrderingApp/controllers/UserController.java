package org.perscholas.Ketotastic.OrderingApp.controllers;

import org.perscholas.Ketotastic.OrderingApp.models.Role;
import org.perscholas.Ketotastic.OrderingApp.models.User;
import org.perscholas.Ketotastic.OrderingApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //user sign up
    @GetMapping("/signup")
    public String signup(Model model){
        List<Role> listRoles=userService.listRoles();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());
        return "signup";
    }


    //new user registration
    @PostMapping("/process_register")
    public ModelAndView processRegistration(@Valid User user, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        if (bindingResult.hasErrors()) {
            model.setViewName("signup");
        }
        else {
            userService.saveUser(user);
            model.addObject("user", new User());
            model.setViewName("registration_success");
        }
        return model;
    }

}
