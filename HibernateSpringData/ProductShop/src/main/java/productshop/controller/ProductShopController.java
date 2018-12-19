package productshop.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import productshop.domain.dtos.CategoryDto;
import productshop.domain.dtos.ProductDto;
import productshop.domain.dtos.UserDto;
import productshop.servicies.interfaces.CategoryService;
import productshop.servicies.interfaces.ProductService;
import productshop.servicies.interfaces.UserService;
import productshop.utils.ResourceFileReader;

import java.io.IOException;
import java.util.Random;


@Controller
public class ProductShopController implements CommandLineRunner {
    private static final String CATEGORIES_NAME_FILE = "files/categories.json";
    private static final String PRODUCTS_NAME_FILE = "files/products.json";
    private static final String USERS_NAME_FILE = "files/users.json";
    private final ResourceFileReader resourceFileReader;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;

    @Autowired
    public ProductShopController(ResourceFileReader resourceFileReader, UserService userService, CategoryService categoryService, ProductService productService, Gson gson) {
        this.resourceFileReader = resourceFileReader;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.gson = gson;
    }


    @Override
    public void run(String... args) throws Exception {

        this.seedUsers();
        this.seedCategories();
        this.seedProducts();


    }

    private void seedProducts() throws IOException {
        String products = resourceFileReader.readFile(PRODUCTS_NAME_FILE);
        ProductDto[] productDtos = gson.fromJson(products, ProductDto[].class);
        productService.seedProducts(productDtos);
    }

    private void seedCategories() throws IOException {
        String categories = this.resourceFileReader.readFile(CATEGORIES_NAME_FILE);
        CategoryDto[] categoryDtos = this.gson.fromJson(categories, CategoryDto[].class);
        this.categoryService.seedCategories(categoryDtos);

    }

    private void seedUsers() throws IOException {
        String usersFileContent = resourceFileReader.readFile(USERS_NAME_FILE);
        UserDto[] userDtos = this.gson.fromJson(usersFileContent, UserDto[].class);
        this.userService.seedUsers(userDtos);
    }
}
