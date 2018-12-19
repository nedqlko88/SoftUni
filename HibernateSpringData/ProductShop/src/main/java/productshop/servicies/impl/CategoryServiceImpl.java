package productshop.servicies.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.CategoryDto;
import productshop.domain.entities.Category;
import productshop.repositories.CategoryRepository;
import productshop.servicies.interfaces.CategoryService;
import productshop.utils.ValidatorUtil;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedCategories(CategoryDto[] categoryDtos) {
        for (CategoryDto categoryDto : categoryDtos) {
            if (!validatorUtil.isValid(categoryDto)) {
                validatorUtil.violations(categoryDto).forEach(v -> System.out.println(v.getMessage()));
                continue;
            }

            Category category = modelMapper.map(categoryDto, Category.class);

            if (!isPresent(category)) {
                categoryRepository.saveAndFlush(category);
            }
        }
    }

    private boolean isPresent(Category category) {
        return categoryRepository.findByName(category.getName()) != null;
    }
}
