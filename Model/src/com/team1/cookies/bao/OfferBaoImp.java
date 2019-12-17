package com.team1.cookies.bao;

import com.team1.cookies.dao.OfferDaoImp;
import com.team1.cookies.dto.OfferDto;

import java.util.List;

public class OfferBaoImp implements OfferBao {
   
    
    private OfferDaoImp offer_dao = new OfferDaoImp(); 
    /*
     * this function is to return list of offers 
     */
   public List<OfferDto> listOffers(){
        
        return offer_dao.getAllOffers();
    }
   
   
    /*
     * this function is to return  offer details 
     */
  public OfferDto getOfferDetails(Integer offer_id){
       
       return offer_dao.getOfferDetails(offer_id);
   }
}
