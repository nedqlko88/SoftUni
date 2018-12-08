package advancedquerying.service;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<String> selectShampoosBySize(String sizeType);

    List<String> selectShampoosByPrice(String price);

    int countShampoosByPrice(BigDecimal price);

    List<String> selectShampoosByIngredients(List<String> names);

    List<String> selectShampoosByIngredientsCount(Long count);

    BigDecimal sumIngredientsByGivenBrand(String brand);
}
