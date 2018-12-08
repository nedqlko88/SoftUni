package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.repository.IngredientRepository;
import advancedquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final ShampooRepository shampooRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, ShampooRepository shampooRepository) {
        this.ingredientRepository = ingredientRepository;
        this.shampooRepository = shampooRepository;
    }

    // Problem 4
    @Override
    public List<String> selectIngredientsByName(String nameStarts) {
        List<Ingredient> ingredients = this.ingredientRepository.findAllByNameIsStartingWith(nameStarts);

        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    // Problem 5
    @Override
    public List<String> selectIngredientsByGivenNames(List<String> input) {
        List<Ingredient> ingredients = this.ingredientRepository.findAllByNameInOrderByPriceAsc(input);

        return ingredients.stream().map(Ingredient::getName).collect(Collectors.toList());
    }

    @Override
    public BigDecimal sumIngredientsByGivenBrand(String brand) {
        Shampoo shampoo = this.shampooRepository.findShampooByBrand(brand);
        List<Ingredient> ingredients = this.ingredientRepository.findIngredientsByShampoosIsContaining(shampoo);

        return ingredients.stream()
                .map(Ingredient::getPrice)
                .reduce(BigDecimal::add)
                .get();
    }




}
