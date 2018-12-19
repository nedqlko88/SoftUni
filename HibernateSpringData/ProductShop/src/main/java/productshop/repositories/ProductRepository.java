package productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshop.domain.entities.Category;
import productshop.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

}
