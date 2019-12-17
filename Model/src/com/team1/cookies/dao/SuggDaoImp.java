package com.team1.cookies.dao;

import com.team1.cookies.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class SuggDaoImp implements SuggDao{
    public SuggDaoImp() {
        super();
    }

    @Override
    public boolean saveSugg(int id, String text) {
        try (JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
        
        //set connection url , username and password
        String dbURL = ConnectionFactory.getUrl();
        String userName=ConnectionFactory.getUsername();
        String userPwd=ConnectionFactory.getPassword();
            
        Connection connection = null;
        connection = DriverManager.getConnection(dbURL,userName,userPwd);
            String sql =
                "INSERT INTO SUGGESTIONS(SUGG_CONTENT, SUGGESTIONS_DATE ,CUSTOMER_ID ) values(?, ?, ? )";
                    
        connection.setAutoCommit(true);  
            
        PreparedStatement ps = connection.prepareStatement(sql);  
        ps.setString(1,text);
        ps.setDate(2,new Date(System.currentTimeMillis()));
        ps.setInt(3,id);
        ps.execute();

        }catch (SQLException e){
             e.printStackTrace();
             return false;
        }
        return false;
    }
}
