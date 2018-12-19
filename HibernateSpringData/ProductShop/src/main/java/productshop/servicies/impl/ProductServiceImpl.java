package productshop.servicies.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import productshop.domain.dtos.ProductDto;
import productshop.domain.entities.Category;
import productshop.domain.entities.Product;
import productshop.domain.entities.User;
import productshop.repositories.CategoryRepository;
import productshop.repositories.ProductRepository;
import productshop.repositories.UserRepository;
import productshop.servicies.interfaces.ProductService;
import productshop.utils.ValidatorUtil;

import javax.validation.ConstraintViolation;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void seedProducts(ProductDto[] productDtos) {
        for (ProductDto dto : productDtos) {
            if (!validatorUtil.isValid(dto)) {
                Set<ConstraintViolation<ProductDto>> validate = validatorUtil.violations(dto);
                validate.forEach(v -> System.out.println(v.getMessage()));
                continue;
            }

            Product product = modelMapper.map(dto, Product.class);

            if (!isPresent(product)) {

                Random random = new Random();
                int i = random.nextInt(2);
                if (i <= 1) {
                    product.setSellerId(getRandomUser(random));
                }
                if (i < 1) {
                    product.setBuyerId(getRandomUser(random));
                }

                product.setCategories(getRandomSetCategory(random));

                productRepository.saveAndFlush(product);
            }
        }
    }

    private boolean isPresent(Product product) {
        return productRepository.findByName(product.getName()) != null;
    }

    private User getRandomUser(Random random) {
        int countUsers =(int)this.userRepository.count();
        int randomId = random.nextInt(countUsers) + 1;
        return userRepository.findFirstById(randomId);
    }

    private Set<Category> getRandomSetCategory(Random random) {
        int categoryCount =(int)this.categoryRepository.count();
        int randomSize = random.nextInt(categoryCount) + 1;
        Set<Category> linkedHashSet = new LinkedHashSet<>();

        for (int c = 0; c < randomSize; c++) {
            int anInt = random.nextInt(categoryCount);
            Category one = categoryRepository.getOne(anInt);
            linkedHashSet.add(one);

        }
        return linkedHashSet;
    }
}
