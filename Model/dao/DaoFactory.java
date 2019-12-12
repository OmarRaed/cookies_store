package com.hassan.aicam.dao;

public class DaoFactory {
    public UserDao createUserDao() {
           return new UserDaoImp();
       }
}
