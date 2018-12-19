package productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshop.domain.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByFirstNameAndLastNameAndAge(String firstName, String lastName, int age);

    User findFirstById(Integer id);

}
