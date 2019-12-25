package com.team1.doses.dao;

import com.team1.cookies.common.ConnectionFactory;
import com.team1.doses.dto.InjectionDto;

import java.util.ArrayList;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class InjectionDaoImp implements InjectionDao{

    //this function is to return all injections from db
    @Override
    public ArrayList<InjectionDto> getAllInjections() {
        
        ArrayList<InjectionDto> injections = null;
        try (JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet()) {

            jdbc.setUrl(ConnectionFactory.getUrl());
            jdbc.setUsername("dos");
            jdbc.setPassword("dos");
            jdbc.setCommand("select *from injection");
            jdbc.execute();
            
            InjectionDto injection = null;
            
            while (jdbc.next()) {
                if (injections == null)
                    injections = new ArrayList<>();
                
                injection = new InjectionDto();
                injection.setDosePerKg(jdbc.getInt(1));
                injection.setDoseNumber(jdbc.getInt(2));
                injection.setName(jdbc.getString(3));
                
                injections.add(injection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return injections;
    }
    
}
