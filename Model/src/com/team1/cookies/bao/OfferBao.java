package com.team1.cookies.bao;

import java.util.List;

import com.team1.cookies.dto.OfferDto;

public interface OfferBao {
    
    /*
     * this function is to return list of offers 
     */
    public List<OfferDto> listOffers();
    
    
    /*
     * this function is to return  offer details 
     */
    public OfferDto getOfferDetails(Integer offer_id);
}
