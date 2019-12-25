package com.team1.cookies.bao;

import com.team1.cookies.dto.OfferDto;

import com.team1.doses.dto.InjectionDto;

import java.util.ArrayList;
import java.util.List;

public interface InjectionBao {
    /*
     * this function is to return list of injections 
     */
    public ArrayList<InjectionDto> getAllInjections();
    
}
