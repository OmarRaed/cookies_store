package com.hassan.aicam.dao;

import com.hassan.aicam.common.ConnectionFactory;
import com.hassan.aicam.common.Queries;
import com.hassan.aicam.dto.User;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.util.Date;

import javax.swing.JOptionPane;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class UserDaoImp implements UserDao {
    public UserDaoImp() {
        super();
    }

    @Override
    public boolean checkLogin(User user) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand("SELECT USERNAME FROM USERS_ WHERE USERNAME = ? AND PASSWORD_ = ? ");
            jdbcRs.setString(1, user.getUserName());
            jdbcRs.setString(2, user.getPassword());

            jdbcRs.execute();
            //JOptionPane.showConfirmDialog(null,user.getUserName()+"  " +user.getPassword());


            if (jdbcRs.next()) {
                return true;

            }

        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(null,e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean insertUser(User user) {
        try (Connection con =
             DriverManager.getConnection(ConnectionFactory.getUrl(), ConnectionFactory.getUsername(),
                                         ConnectionFactory.getPassword())) {

            PreparedStatement ps = con.prepareStatement(Queries.INSERT_USER);
            
            ps.setString(1, user.getFName());
            ps.setString(2, user.getSName());
            ps.setString(3, user.getTName());
            ps.setString(4, user.getLName());
            ps.setString(5, user.getCountry());
            ps.setString(6, user.getCity());
            ps.setString(7, user.getDis());
            // check if the inserted date is not setted we we will set it
            if (user.getBirthDay() != null)
                ps.setDate(8, new java.sql.Date(user.getBirthDay().getTime()));
            else
                ps.setNull(8, java.sql
                                      .Types
                                      .DATE);
            //JOptionPane.showConfirmDialog(null, "date ++++++++> "+user.getBirthDay());
            ps.setString(9, user.getUserName());
            ps.setString(10, user.getPassword());
            ps.setString(11, user.getEmail());
            ps.setString(12, user.getPhone());
            ps.setString(13, user.getLandLineNum());


            ps.execute(); 


        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(null,e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean serveltCreate_Insert(Date date, String userName) {
        try (Connection con =
             DriverManager.getConnection(ConnectionFactory.getUrl(), ConnectionFactory.getUsername(),
                                         ConnectionFactory.getPassword())) {

            PreparedStatement ps = con.prepareStatement(Queries.INSERT_SERVELTCREATE);
            ps.setString(1, userName);
            if (date != null)
                ps.setDate(2, new java.sql.Date(date.getTime()));
            else
                ps.setNull(2, java.sql
                                  .Types
                                  .DATE);


            ps.execute();


        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            e.printStackTrace();
            return false;

        }

        return true;
    }

    @Override
    public boolean appsLog(Date date, int status) {
        try (Connection con =
             DriverManager.getConnection(ConnectionFactory.getUrl(), ConnectionFactory.getUsername(),
                                         ConnectionFactory.getPassword())) {

            PreparedStatement ps = con.prepareStatement(Queries.INSERT_APPDATA);
            ps.setInt(1, status);
            if (date != null)
                ps.setDate(2, new java.sql.Date(date.getTime()));
            else
                ps.setNull(2, java.sql
                                  .Types
                                  .DATE);


            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
        return true;
    }
}
