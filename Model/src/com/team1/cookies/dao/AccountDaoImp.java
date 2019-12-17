package com.team1.cookies.dao;

import com.team1.cookies.common.ConnectionFactory;
import com.team1.cookies.dto.CustomerDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.team1.cookies.dto.AccountDto;

public class AccountDaoImp implements AccountDao {
    
    public final static int USER_NOT_FOUND = -10000 ;

    @Override
    public boolean updateUser(AccountDto account) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
        
        //set connection url , username and password
        String dbURL = ConnectionFactory.getUrl();
        String userName=ConnectionFactory.getUsername();
        String userPwd=ConnectionFactory.getPassword();
            
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
    @Override
    public int sign_in(CustomerDto customer) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
            jdbc.setUrl(ConnectionFactory.getUrl());
            jdbc.setUsername(ConnectionFactory.getUsername());
            jdbc.setPassword(ConnectionFactory.getPassword());
            jdbc.setCommand("select * " + 
            "from customer " + 
            "where lower(email)= ? and pass= ?");
                jdbc.setString(1,customer.getEmail().toLowerCase());
                jdbc.setString(2,customer.getPassword());
            jdbc.execute();
            if(jdbc.next()){
                return jdbc.getInt("CUSTOMER_ID");
                }
                }
        catch(Exception e){
        e.printStackTrace();
        }
        return USER_NOT_FOUND;
    }

    @Override
    public boolean sign_up(CustomerDto customer) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){

            //set connection url , username and password
            String dbURL = ConnectionFactory.getUrl();
            String userName=ConnectionFactory.getUsername();
            String userPwd=ConnectionFactory.getPassword();
            Connection con=null;
            con=   DriverManager.getConnection(dbURL,userName, userPwd);
                
           String insertion= "insert into customer (email,pass,first_name,last_name) " + 
           "values(?,?,?,?)";
            con.setAutoCommit(true);
            PreparedStatement statement =con.prepareStatement(insertion);
             statement.setString(1,customer.getEmail());
             statement.setString(2,customer.getPassword());
            statement.setString(3,customer.getFirst_name());
            statement.setString(4,customer.getLast_name());
            
          
            
            statement.executeUpdate();
            con.close();
            return true;
            }
        
        catch(Exception e){
        e.printStackTrace();
        }
        return false;
    }
}
