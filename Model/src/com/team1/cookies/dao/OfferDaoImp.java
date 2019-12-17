package com.team1.cookies.dao;

import com.team1.cookies.common.ConnectionFactory;

import java.io.InputStream;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;


import com.team1.cookies.dto.OfferDto;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class OfferDaoImp implements OfferDao {
    public OfferDaoImp() {
        super();
    }

    //this function is to return all offers from db
    public List<OfferDto> getAllOffers() {
        List<OfferDto> offer = null;
        try (JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet()) {

            jdbc.setUrl(ConnectionFactory.getUrl());
            jdbc.setUsername(ConnectionFactory.getUsername());
            jdbc.setPassword(ConnectionFactory.getPassword());
            jdbc.setCommand("select offer_id,offer_description,offer_price,offer_quantity,offer_image " + "from offers ");
            jdbc.execute();
            
            OfferDto offerObject = null;
            
            while (jdbc.next()) {
                if (offer == null)
                    offer = new ArrayList<>();
                offerObject = new OfferDto();
                offerObject.setOffer_id(jdbc.getInt(1));
                offerObject.setOffer_describe(jdbc.getString(2));
                offerObject.setOffer_price(jdbc.getInt(3));
                offerObject.setOffer_quantity(jdbc.getInt(4));
                offerObject.setOffer_image(jdbc.getBytes(5));
                offer.add(offerObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offer;
    }

    //this function is to return a specific offer details
   public OfferDto getOfferDetails(Integer offer_id) {
        OfferDto offerObject = null;
        try (JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            jdbc.setUrl(ConnectionFactory.getUrl());
            jdbc.setUsername(ConnectionFactory.getUsername());
            jdbc.setPassword(ConnectionFactory.getPassword());
            jdbc.setCommand("select offer_id, offer_description,offer_price,offer_quantity,offer_image, PRODUCT_ID from offers " +
                            "WHERE offer_id=? ");
            jdbc.setInt(1,offer_id);
            jdbc.execute();
            while (jdbc.next()) {
                offerObject = new OfferDto();
                offerObject.setOffer_id(jdbc.getInt(1));
                offerObject.setOffer_describe(jdbc.getString(2));
                offerObject.setOffer_price(jdbc.getInt(3));
                offerObject.setOffer_quantity(jdbc.getInt(4));
                offerObject.setOffer_image(jdbc.getBytes(5));
                offerObject.setOffer_product(jdbc.getInt(6));
                System.out.println(offerObject.getOffer_product() + "OFFER DAO IMP PRODUCT ID");
            }
            } catch (Exception e) {
            e.printStackTrace();
            }

            return offerObject;

    }
}
