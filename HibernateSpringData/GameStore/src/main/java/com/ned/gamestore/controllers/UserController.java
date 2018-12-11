package com.ned.gamestore.controllers;

import com.ned.gamestore.AuthenticationContext;
import com.ned.gamestore.models.User;
import com.ned.gamestore.services.interfaces.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    private AuthenticationContext authenticationContext;

    public UserController(UserService userService, AuthenticationContext authenticationContext) {
        this.userService = userService;
        this.authenticationContext = authenticationContext;
    }

    public String register(String email, String password, String confirmPassword, String fullName) {
        User user = new User();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);
        try {
            this.userService.registerUser(user, confirmPassword);
            return String.format("%s registered successfully!", user.getFullName());
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String login(String email, String password) {
        if (!this.userService.checkIfUserExists(email)) {
            return "User does not exist!";
        }
        this.authenticationContext.setLoggedInUser(this.userService.getUserDtoByEmail(email));
        return "User logged in successfully!";
    }
}
