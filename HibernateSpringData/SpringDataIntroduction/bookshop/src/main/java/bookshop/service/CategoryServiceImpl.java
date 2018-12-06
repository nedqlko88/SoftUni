package bookshop.service;

import bookshop.domain.entities.Category;
import bookshop.repository.CategoryRepository;
import bookshop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_STRING_PATH = "F:\\softUni\\Repository\\HibernateSpringData\\SpringDataIntroduction\\bookshop\\src\\main\\resources\\files\\categories.txt";

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(this.fileUtil.getFileContent(CATEGORY_STRING_PATH)).
                    forEach(e -> {
                        Category category = new Category();
                        category.setName(e);
                        this.categoryRepository.save (category);
                    });
        }


    }
}
