package advancedquerying.controller;

import advancedquerying.service.IngredientService;
import advancedquerying.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Scanner;


@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;


    @Autowired
    public AppController(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {

    }
}

