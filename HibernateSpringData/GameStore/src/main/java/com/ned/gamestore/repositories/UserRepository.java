package com.ned.gamestore.repositories;

import com.ned.gamestore.models.User;
import com.ned.gamestore.models.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


    // tova e edin nachin da si vyrnem mapper drugiq e v userserviceimpl
//    @Query("select new com.ned.gamestore.models.UserDto(u.email, u.isAdmin) From User AS u where u.email = :email")
//    UserDto getUserByEmail(@Param(value = "email") String email);
}
