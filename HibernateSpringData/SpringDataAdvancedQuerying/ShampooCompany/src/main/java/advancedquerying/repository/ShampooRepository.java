package advancedquerying.repository;

import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
        List<Shampoo> findAllBySizeOrderById(Size size);

        List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);




}
