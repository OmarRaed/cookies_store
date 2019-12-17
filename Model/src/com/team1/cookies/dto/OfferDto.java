package com.team1.cookies.dto;

import java.io.InputStream;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.internal.oxm.conversion.Base64;

public class OfferDto {
    public OfferDto() {
        super();
    }

    public OfferDto(Integer offer_quantity, Integer offer_price, String offer_describe,byte[] offer_image) {
        super();
        this.offer_quantity = offer_quantity;
        this.offer_price = offer_price;
        this.offer_describe = offer_describe;
        this.offer_image = offer_image;
    }

    private Integer offer_id;
    private Integer offer_quantity;
    private Integer offer_price;
    private Integer offer_product;
    private String offer_describe;
    private byte[] offer_image;
    private String stringImage;


    public void setOffer_product(Integer offer_product) {
        this.offer_product = offer_product;
    }

    public Integer getOffer_product() {
        return offer_product;
    }

    public void setOffer_id(Integer offer_id) {
        this.offer_id = offer_id;
    }

    public Integer getOffer_id() {
        return offer_id;
    }

    public void setOffer_quantity(Integer offer_quantity) {
        this.offer_quantity = offer_quantity;
    }

    public Integer getOffer_quantity() {
        return offer_quantity;
    }

    public void setOffer_price(Integer offer_price) {
        this.offer_price = offer_price;
    }

    public Integer getOffer_price() {
        return offer_price;
    }

    public void setOffer_describe(String offer_describe) {
        this.offer_describe = offer_describe;
    }

    public String getOffer_describe() {
        return offer_describe;
    }

    public void setOffer_image(byte[] offer_image ) {
        this.offer_image = offer_image;
        this.stringImage = new String(Base64.base64Encode(offer_image));
    }

    public byte[] getOffer_image() {
        return offer_image;
    }

    public void setStringImages(String stringImage) {
        this.stringImage = stringImage;
    }

    public String getStringImage() {
        return stringImage;
    }
}
