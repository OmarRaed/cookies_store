package com.team1.cookies.dao;

import java.util.List;

import com.team1.cookies.dto.CartDto;

public interface CartDao {
    
    public List<CartDto> getCart(int customerId);    
    public boolean addToCart(CartDto cart);
    public boolean removeCart(int cartId);
}
