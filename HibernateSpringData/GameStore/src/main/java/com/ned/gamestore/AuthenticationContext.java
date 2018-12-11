package com.ned.gamestore;

import com.ned.gamestore.models.UserDto;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationContext {
    private UserDto loggedInUser;



    public UserDto getLoggedInUser() {
        return this.loggedInUser;
    }

    public void setLoggedInUser(UserDto loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
