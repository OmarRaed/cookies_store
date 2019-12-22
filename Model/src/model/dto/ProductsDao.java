package model.dto;

import java.util.List;

public interface ProductsDao {

    public List<ProductDto> getAllProducts();

    public List<ProductDto> getProductsByCategoryId(int id);

    public ProductDto getProductById(int id);

}
