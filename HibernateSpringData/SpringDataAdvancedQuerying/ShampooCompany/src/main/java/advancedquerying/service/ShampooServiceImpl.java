package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import advancedquerying.repository.IngredientRepository;
import advancedquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }


    // Problem 1
    @Override
    public List<String> selectShampoosBySize(String sizeType) {
        Size size = Size.valueOf(sizeType.toUpperCase());

        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(size);

        return shampoos.
                stream().
                map(s -> s.getBrand() + " " + s.getSize().name() + " " + s.getPrice() + "lv.")
                .collect(Collectors.toList());
    }

    // Problem 3
    @Override
    public List<String> selectShampoosByPrice(String input) {
        BigDecimal price = new BigDecimal(input);
        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);

        return shampoos.stream().
                map(s -> String.format("%s %s %.2flv.",
                        s.getBrand(),
                        s.getSize().name(),
                        s.getPrice())).
                collect(Collectors.toList());

    }

    // Problem 6
    @Override
    public int countShampoosByPrice(BigDecimal price) {
        return this.shampooRepository.countShampooByPriceLessThan(price);

    }

    // Problem 7
    @Override
    public List<String> selectShampoosByIngredients(List<String> names) {
        Set<Ingredient> ingredients = this.ingredientRepository.findAllByNameIn(names);

        List<Shampoo> shampoos = this.shampooRepository.findByIngredientsIn(ingredients);

        return shampoos.stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());

    }

    // Problem 8
    @Override
    public List<String> selectShampoosByIngredientsCount(Long count) {
        List<Shampoo> shampoos = this.shampooRepository.findShampooByIngredientsCount(count);

       return shampoos.stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal sumIngredientsByGivenBrand(String brand) {
        Shampoo shampoo = this.shampooRepository.findShampooByBrand(brand);


        return  shampoo.getIngredients().
                stream().
                map(Ingredient::getPrice)
                .reduce(BigDecimal::add)
                .get();
    }

}
