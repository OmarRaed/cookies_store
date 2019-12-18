package model.dto;

import java.util.List;

public interface ProductsDao {
    
    public List<ProductDto> getAllProducts() ;
    public ProductDto getProductById(int id);
    
}
