package com.ned.gamestore.services.impl;

import com.ned.gamestore.models.User;
import com.ned.gamestore.models.UserDto;
import com.ned.gamestore.repositories.UserRepository;
import com.ned.gamestore.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private Validator validator;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.getValidator();
        modelMapper = new ModelMapper();

    }

    @Override
    public void registerUser(User user, String confirmPassword) {
        if (checkIfUserExists(user.getEmail())) {
            throw new IllegalArgumentException("User already exist!");
        }
        if (!user.getPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match!");
        }

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        if (constraintViolations.size() == 0) {
            this.userRepository.save(user);
        } else {
            for (ConstraintViolation<User> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        }
    }



    @Override
    public boolean checkIfUserExists(String email) {
        User user = this.userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public UserDto getUserDtoByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        UserDto userDto = new UserDto();
        this.modelMapper.map(user, userDto);
        return userDto;

    }


    public void getValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       this.validator = factory.getValidator();
    }

}
