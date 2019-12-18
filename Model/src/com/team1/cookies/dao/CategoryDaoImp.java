package com.team1.cookies.dao;

import com.team1.cookies.common.ConnectionFactory;
import com.team1.cookies.common.Queries;
import com.team1.cookies.dto.CategoryDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class CategoryDaoImp implements CategoryDao {
    public CategoryDaoImp() {
        super();
    }

    @Override
    public List<CategoryDto> listAllCatogries() {
       List<CategoryDto> catogories = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.GET_ALL_CATOGORIES);
            jdbcRs.execute();
            CategoryDto cato = null;
            while (jdbcRs.next()) {
                if (catogories == null)
                    catogories = new ArrayList<>();
                cato = new CategoryDto();
                cato.setId(jdbcRs.getInt(1));
                cato.setName(jdbcRs.getString(2));
                catogories.add(cato);
                
            }
        } catch (Exception e){ 
            JOptionPane.showConfirmDialog(null,e.getMessage());
            e.printStackTrace();
        }
        return catogories;
    }
}
