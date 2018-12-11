package com.ned.gamestore.services.interfaces;


import com.ned.gamestore.models.User;
import com.ned.gamestore.models.UserDto;
import org.springframework.data.jpa.repository.Query;

public interface UserService {
    void registerUser(User user, String confirmPassword);

    boolean checkIfUserExists(String email);

    UserDto getUserDtoByEmail(String email);


}
