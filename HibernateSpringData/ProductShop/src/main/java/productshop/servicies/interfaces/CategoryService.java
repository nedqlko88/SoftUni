package productshop.servicies.interfaces;

import productshop.domain.dtos.CategoryDto;
import productshop.domain.entities.Category;

public interface CategoryService {
    void seedCategories(CategoryDto[] categoryDtos);
}
