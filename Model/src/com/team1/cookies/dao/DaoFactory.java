package com.team1.cookies.dao;

public class DaoFactory {

    public CategoryDao getDaoGatogory(){
        return new CategoryDaoImp();
        }    
    
}
