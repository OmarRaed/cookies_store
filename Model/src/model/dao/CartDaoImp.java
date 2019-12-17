package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import model.dto.CartDto;

public class CartDaoImp implements CartDao{

    @Override
    public List<CartDto> getCart(int customerId) {
        
        List<CartDto> cartList = null ;
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
                    //set connection url , username and password
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("cookies_shop");
                    jdbc.setPassword("cookies");
            
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
}
