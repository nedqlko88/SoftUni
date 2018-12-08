package advancedquerying.controller;

import advancedquerying.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;

    @Autowired
    public AppController(ShampooService shampooService) {
        this.shampooService = shampooService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        this.shampooService.selectShampoosByPrice(input).forEach(System.out::println);
    }
}

