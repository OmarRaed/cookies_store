package com.fym.jsf.view;

import java.awt.image.RenderedImage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.io.Serializable;

import com.team1.cookies.bao.OfferBao;
import com.team1.cookies.bao.OfferBaoImp;
import com.team1.cookies.dto.OfferDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;

import javax.imageio.ImageIO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.internal.oxm.conversion.Base64;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class backing_offers implements Serializable {
    public backing_offers() {
        super();
    }
    private static final long serialVersionUID = 1L;


    private OfferBao bao_object = new OfferBaoImp();

    private List<OfferDto> offersList = bao_object.listOffers();

    private List<String> stringImages;

    @PostConstruct
    public void init() {
        stringImages = new ArrayList<String>();
        try {
            for (int i = 0; i < offersList.size(); i++) {
                String string_image = offersList.get(i).getStringImage();
                stringImages.add(string_image);
            }
            this.setStringImages(stringImages);
        } catch (Exception ex) {

        }
    }

    public void setStringImages(List<String> stringImages) {
        this.stringImages = stringImages;
    }

    public List<String> getStringImages() {
        return stringImages;
    }


    public void setOffersList(List<OfferDto> offersList) {
        this.offersList = offersList;
    }

    public List<OfferDto> getOffersList() {
        return offersList;
    }


    public String offersDetails() {
        
        System.out.println("Hi");
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParams = context.getExternalContext().getRequestParameterMap();
        String offerId = (String) requestParams.get("offerId");
        FacesContext context2 = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
        session.setAttribute("offerId", offerId);
        session.setAttribute("customerId", 2);
        System.out.println(offerId);
        if (offerId.equals(null))
            return null;
        else {
            System.out.println("hHkk");
            return "go details";
        }
    }

}
