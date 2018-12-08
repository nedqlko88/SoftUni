package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameIsStartingWith(String nameStarts);

    List<Ingredient> findAllByNameInOrderByPriceAsc(List<String> input);

    Set<Ingredient> findAllByNameIn(List<String> names);

    List<Ingredient> findIngredientsByShampoosIsContaining(Shampoo shampoo);

}
