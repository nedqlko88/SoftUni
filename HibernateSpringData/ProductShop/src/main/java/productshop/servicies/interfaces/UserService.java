package productshop.servicies.interfaces;

import productshop.domain.dtos.UserDto;

import java.util.List;

public interface UserService {
    void seedUsers(UserDto[] userDtos);

}
