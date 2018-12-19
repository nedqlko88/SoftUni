package productshop.servicies.interfaces;

import productshop.domain.dtos.ProductDto;

public interface ProductService {
    void seedProducts(ProductDto[] productDtos);
}
