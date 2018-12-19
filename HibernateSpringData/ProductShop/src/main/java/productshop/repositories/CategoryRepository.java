package productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshop.domain.entities.Category;
import productshop.domain.entities.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

    Category findFirstById(Integer id);

}
