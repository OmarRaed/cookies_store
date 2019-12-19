package com.team1.cookies.dao;

import com.team1.cookies.common.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.team1.cookies.dto.CartDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CartDaoImp implements CartDao{

    @Override
    public List<CartDto> getCart(int customerId) {
        
        List<CartDto> cartList = null ;
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
            
            jdbc.setUrl(ConnectionFactory.getUrl());
            jdbc.setUsername(ConnectionFactory.getUsername());
            jdbc.setPassword(ConnectionFactory.getPassword());
            
            jdbc.setCommand("SELECT PRODUCT_NAME ,IMAGE , CART_ID, QUANTITY , TOTAL_PRICE " +
                            "FROM CART " +
                            "NATURAL JOIN PRODUCT " +
                            "WHERE CUSTOMER_ID = ? ");
            
            jdbc.setInt(1, customerId);            
            jdbc.execute();
            
            while(jdbc.next()){            
                
                if(cartList == null)
                        cartList = new ArrayList<>();
          
                CartDto cartDto = new CartDto();
                cartDto.setId(jdbc.getInt("CART_ID"));
                cartDto.setProductName(jdbc.getString("PRODUCT_NAME"));
                cartDto.setImage(jdbc.getBytes("IMAGE"));
                cartDto.setQuantity(jdbc.getInt("QUANTITY"));
                cartDto.setPrice(jdbc.getInt("TOTAL_PRICE"));
                
                cartList.add(cartDto);
                
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
           
        return cartList;
    }

    @Override
    public boolean addToCart(CartDto cart) {
        try{
        System.out.println(cart.getProductId() + "CART DAO IMP PRODUCT ID");
        
        //set connection url , username and password
        String dbURL = ConnectionFactory.getUrl();
        String userName=ConnectionFactory.getUsername();
        String userPwd=ConnectionFactory.getPassword();
            
        Connection connection = null;
        connection = DriverManager.getConnection(dbURL,userName,userPwd);
            String sql ="INSERT INTO CART(QUANTITY, TOTAL_PRICE, CUSTOMER_ID, PRODUCT_ID)" +
                " VALUES(?, ?, ?, ?)";
                    
        connection.setAutoCommit(true);  
        PreparedStatement statement = connection.prepareStatement(sql);  
            
        statement.setInt(1, cart.getQuantity());
        statement.setInt(2, cart.getPrice());
        statement.setInt(3, cart.getCustomerId());
        statement.setInt(4, cart.getProductId());;
            
        statement.executeUpdate();
        connection.close();
            
            return true;
                    
        }catch(Exception e){
        e.printStackTrace();
        return false;
        }
        
    }

    @Override
    public boolean removeCart(int cartId) {
        
        try{
        
            //set connection url , username and password
            String dbURL = ConnectionFactory.getUrl();
            String userName=ConnectionFactory.getUsername();
            String userPwd=ConnectionFactory.getPassword();
            Connection connection = null;
            connection = DriverManager.getConnection(dbURL,userName,userPwd);
            String sql = "DELETE FROM CART" +
                                " WHERE CART_ID = ?";
                
                
            connection.setAutoCommit(true);  
            PreparedStatement statement = connection.prepareStatement(sql);  
                
            statement.setInt(1, cartId);            
            statement.execute();
                     
            }catch(Exception e){
                e.printStackTrace();
            }
       return true;    
    }
}
