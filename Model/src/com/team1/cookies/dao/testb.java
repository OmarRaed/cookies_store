package com.team1.cookies.dao;

import com.team1.cookies.dto.CategoryDto;

import java.util.List;

public class testb {
    public testb() {
        super();
    }

    public static void main(String[] args) {
        testb testb = new testb(); 
        
        List<CategoryDto> cats = new DaoFactory().getDaoGatogory().listAllCatogries();
        
        
        for (CategoryDto cat :cats)
        {
            System.out.print(cat.getName());
        }
    }
}
