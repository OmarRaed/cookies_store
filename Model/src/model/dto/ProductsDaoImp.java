package model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ProductsDaoImp implements ProductsDao{

    @Override
    public List<ProductDto> getAllProducts() {
        
    List<ProductDto> products = null ;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
            
    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1522:xe");            
    jdbc.setUsername("cookies");            
    jdbc.setPassword("cookies");
            
        
    jdbc.setCommand("SELECT * FROM PRODUCT");
        
    jdbc.execute() ;
        
    while(jdbc.next()){
        if(products == null)
            products = new ArrayList<>() ;  
    
        ProductDto product = new ProductDto() ;
        product.setId(jdbc.getInt("PRODUCT_ID"))  ;
        product.setProductName(jdbc.getString("PRODUCT_NAME")) ;
        product.setImage(jdbc.getBytes("IMAGE"))  ;
        product.setSmallPrice(jdbc.getInt("SMALL_PRICE"))  ;
        product.setMediumPrice(jdbc.getInt("MEDIUM_PRICE"))  ;
        product.setStock(jdbc.getInt("STOCK")) ;
        product.setProductDescription(jdbc.getString("PRODUCT_DESCRIPTION"))  ;
        product.setCategoryId(jdbc.getInt("CATEGORY_ID"))  ;
        
        products.add(product);
    
    }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return products ;
    }

    @Override
    public ProductDto getProductById(int id) {
        
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
            
    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1522:xe");            
    jdbc.setUsername("cookies");            
    jdbc.setPassword("cookies");
        
    jdbc.setCommand("SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?");
        
    jdbc.setInt(1, id);
    
    jdbc.execute() ;
        
    if(jdbc.next()){
           
        ProductDto product = new ProductDto() ;
        product.setId(jdbc.getInt("PRODUCT_ID"))  ;
        product.setProductName(jdbc.getString("PRODUCT_NAME")) ;
        product.setImage(jdbc.getBytes("IMAGE"))  ;
        product.setSmallPrice(jdbc.getInt("SMALL_PRICE"))  ;
        product.setMediumPrice(jdbc.getInt("MEDIUM_PRICE"))  ;
        product.setStock(jdbc.getInt("STOCK")) ;
        product.setProductDescription(jdbc.getString("PRODUCT_DESCRIPTION"))  ;
        product.setCategoryId(jdbc.getInt("CATEGORY_ID"))  ;
        
        return product ;
    
    }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return new ProductDto() ;
    }
}
