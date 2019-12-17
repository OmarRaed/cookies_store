package com.team1.cookies.dto;

import java.util.Base64;

public class CartDto {
    private int id ,price , quantity, customerId, productId ;
    private String productName ,imageString ;
    private byte[] image ;


    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImage(byte[] image) {
        this.image = image;
        this.imageString= new String(Base64.getEncoder().encode(image));
    }

    public byte[] getImage() {
        return image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
