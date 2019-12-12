package com.hassan.aicam.dao;

import com.hassan.aicam.dto.User;

import java.util.Date;

public interface  UserDao {
     
     boolean checkLogin(User user);
    
     boolean insertUser(User user);
     
     boolean appsLog (Date date , int status);
     
     boolean serveltCreate_Insert(Date date , String userName);
}
