package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {

    List<String> selectIngredientsByName(String nameStarts);

    List<String> selectIngredientsByGivenNames(List<String> input);

    BigDecimal sumIngredientsByGivenBrand(String brand);
}
