package model.dao;

import java.util.List;

import model.dto.CartDto;

public interface CartDao {
    
    public List<CartDto> getCart(int customerId);
}
