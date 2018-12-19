package productshop.servicies.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.UserDto;
import productshop.domain.entities.User;
import productshop.repositories.UserRepository;
import productshop.servicies.interfaces.UserService;
import productshop.utils.ValidatorUtil;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedUsers(UserDto[] userDtos) {
        for (UserDto userDto : userDtos) {
            if (!this.validatorUtil.isValid(userDto)) {
                validatorUtil.violations(userDto).
                        forEach(v -> System.out.println(v.getMessage()));
                continue;
            }

            User entity = modelMapper.map(userDto, User.class);

            if (!this.isPresent(entity)) {
                this.userRepository.saveAndFlush(entity);
            }
        }
    }

    private boolean isPresent(User entity) {
        User userInRepo = this.userRepository.
                findByFirstNameAndLastNameAndAge(
                        entity.getFirstName(),
                        entity.getLastName(),
                        entity.getAge());
        return userInRepo != null;
    }
}
