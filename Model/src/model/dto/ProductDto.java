package model.dto;

import java.util.Base64;

public class ProductDto {
    
    private int id ;
    private byte[] image ;
    private String productName ;
    private String imageString ;
    private int smallPrice ;
    private int mediumPrice ;
    private int stock ;
    private String productDescription ;
    private int categoryId ;

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public String getImageString() {
        return imageString;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImage(byte[] image) {
        this.image = image;
        this.imageString= new String(Base64.getEncoder().encode(image));
    }

    public byte[] getImage() {
        return image;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setSmallPrice(int smallPrice) {
        this.smallPrice = smallPrice;
    }

    public int getSmallPrice() {
        return smallPrice;
    }

    public void setMediumPrice(int mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public int getMediumPrice() {
        return mediumPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

}
