package com.team1.cookies.dao;

import com.team1.cookies.dto.OfferDto;

import java.util.List;

public interface OfferDao {

    /*
     * this function is to return list of offers 
     */
    public List<OfferDto> getAllOffers();

    /*
     * this function is to return  offer details 
     */
   public OfferDto getOfferDetails(Integer offer_id);
}
