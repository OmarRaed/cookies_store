package com.fym.jsf.view;

import com.team1.cookies.bao.OfferBao;
import com.team1.cookies.bao.OfferBaoImp;
import com.team1.cookies.dao.CartDao;
import com.team1.cookies.dao.CartDaoImp;
import com.team1.cookies.dto.CartDto;
import com.team1.cookies.dto.OfferDto;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import org.eclipse.persistence.internal.oxm.conversion.Base64;

public class backing_details {
    public backing_details() {
        super();
    }


    //backing bean attributes
    private Integer offer_id;
    private Integer offer_price;
    private Integer offer_quantity;
    private byte[] offer_image;
    private String offer_describe, string_image;

    //To create reference from offerBao,offerDto
    private OfferBao bao_object = new OfferBaoImp();
    private OfferDto offer_dto ;

    @PostConstruct
    public void init() {
        /*  FacesContext context = FacesContext.getCurrentInstance();
            Map requestParams = context.getExternalContext().getRequestParameterMap();
            Integer offerId = (Integer) requestParams.get("offerId");*/
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        Integer offerId = Integer.parseInt((String) session.getAttribute("offerId"));
        this.setOffer_id(offerId);
        System.out.println(offerId + "from 2nd bean");
        offer_dto = bao_object.getOfferDetails(getOffer_id());
        this.setOffer_describe(offer_dto.getOffer_describe());
        this.setOffer_image(offer_dto.getOffer_image());
        this.setOffer_price(offer_dto.getOffer_price());
        this.setOffer_quantity(offer_dto.getOffer_quantity());
    }


    public void setOffer_id(Integer offer_id) {
        this.offer_id = offer_id;
    }

    public Integer getOffer_id() {
        return offer_id;
    }

    public void setOffer_image(byte[] offer_image) {
        this.offer_image = offer_image;
        this.string_image = new String(Base64.base64Encode(offer_image));
    }

    public byte[] getOffer_image() {
        return offer_image;
    }

    public void setOffer_describe(String offer_describe) {
        this.offer_describe = offer_describe;
    }

    public String getOffer_describe() {
        return offer_describe;
    }

    public void setOffer_price(Integer offer_price) {
        this.offer_price = offer_price;
    }

    public Integer getOffer_price() {
        return offer_price;
    }

    public void setOffer_quantity(Integer offer_quantity) {
        this.offer_quantity = offer_quantity;
    }

    public Integer getOffer_quantity() {
        return offer_quantity;
    }

    public String getString_image() {
        return string_image;
    }

    public String offersCart() {
        
        //create a new CartDto object
        CartDto cart = new CartDto() ;        
        
        //get the customer ID
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        int customerId = (Integer) session.getAttribute("customerId");
        
        //set cart details
        cart.setPrice(offer_dto.getOffer_price());
        cart.setProductId(offer_dto.getOffer_product());
        cart.setQuantity(offer_dto.getOffer_quantity());
        cart.setCustomerId(customerId);

        //add this to the cart
        CartDao  cartDao = new CartDaoImp() ;
        cartDao.addToCart(cart);
        
        return "go to cart";
    }
}
