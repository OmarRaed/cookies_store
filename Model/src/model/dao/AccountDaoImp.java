package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import model.dto.AccountDto;

public class AccountDaoImp implements AccountDao {

    @Override
    public boolean updateUser(AccountDto account) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
        
                    //set connection url , username and password
                    String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
                    String userName="cookies_shop";
                    String userPwd="cookies";
        Connection connection = null;
        connection = DriverManager.getConnection(dbURL,userName,userPwd);
            String sql ="UPDATE CUSTOMER " +
                        "SET FIRST_NAME = ? , LAST_NAME = ? , ADDRESS = ? , PHONE = ? " +
                        "WHERE CUSTOMER_ID = ? ";
            
            
        connection.setAutoCommit(true);  
        PreparedStatement statement = connection.prepareStatement(sql);  
            
        statement.setString(1,account.getFirstName());
        statement.setString(2,account.getLastName());
        statement.setString(3,account.getAddress());
        statement.setString(4,account.getMobile());
        statement.setInt(5,account.getId());
        statement.executeUpdate();
        connection.close();
            
            return true;
                    
        }catch(Exception e){
        e.printStackTrace();
        return false;
        }
        
        }
}
