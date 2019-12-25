package com.team1.cookies.bao;

import com.team1.cookies.dao.AccountDao;
import com.team1.cookies.dao.AccountDaoImp;
import com.team1.cookies.dao.OfferDaoImp;
import com.team1.doses.dao.InjectionDaoImp;
import com.team1.doses.dto.InjectionDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InjectionBaoImp implements InjectionBao {
    
    private InjectionDaoImp injection_dao = new InjectionDaoImp(); 
    
    @Override
    public ArrayList<InjectionDto> getAllInjections() {     
        return injection_dao.getAllInjections();
    }
}
