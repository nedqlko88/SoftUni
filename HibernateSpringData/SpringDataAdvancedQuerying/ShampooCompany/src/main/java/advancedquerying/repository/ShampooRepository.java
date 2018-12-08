package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
        List<Shampoo> findAllBySizeOrderById(Size size);

        List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

        int countShampooByPriceLessThan(BigDecimal price);

        @Query(value = "SELECT s FROM advancedquerying.domain.entities.Shampoo AS s JOIN s.ingredients AS i WHERE i IN :ingredients")
        List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);


        // Problem 8
//        This is the working SQL
//        SELECT s.brand, count(ingredient_id) As `counts`
//        FROM shampoos as s
//        JOIN shampoos_ingredients si
//        ON s.id = si.shampoo_id
//        JOIN ingredients i
//        ON si.ingredient_id = i.id
//        GROUP BY s.brand
//        HAVING counts < 2;
        @Query(value = "SELECT s from advancedquerying.domain.entities.Shampoo AS s JOIN s.ingredients AS i GROUP BY s having count(i) < :count")
        List<Shampoo> findShampooByIngredientsCount(@Param(value = "count") Long count);

        Shampoo findShampooByBrand(String brand);



}
