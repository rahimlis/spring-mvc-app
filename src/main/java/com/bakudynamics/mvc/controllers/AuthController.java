package com.bakudynamics.mvc.controllers;

import com.bakudynamics.mvc.dao.User;
import com.bakudynamics.mvc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AuthController {

    private UsersService usersService;


    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", usersService.getUsers());
        return "admin/admin";
    }

    @RequestMapping("/denied")
    public String denied() {
        return "denied";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "auth/login";
    }

    @RequestMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/users.create";
    }

    @RequestMapping("/users/store")
    public String storeUser(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "auth/users.create";
        }


        if (usersService.exists(user)) {
            return handleDuplicate(result);
        }

        user.setEnabled(true);
        user.setAuthority("ROLE_USER");
        try {
            usersService.create(user);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return handleDuplicate(result);
        }

        return "auth/users.created";
    }

    @RequestMapping("/logged_out")
    public String showLoggedOut() {
        return "auth/logged_out";
    }


    private String handleDuplicate(BindingResult result) {
        System.out.println("Caught duplicate username");
        result.rejectValue("username", "DuplicateKey.user.username", "This username has already been taken");
        return "auth/users.create";
    }


    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
