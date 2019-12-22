package view.backing;

import com.team1.cookies.dao.DaoFactory;
import com.team1.cookies.dto.CategoryDto;

import java.io.IOException;
import java.io.Serializable;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;


/*
 * this created by H.Omar 
 * this class is the backing bean binded by header.jsf page which acts as the upper header in all pages 
 */

@ManagedBean(name = "backing_header")
@SessionScoped
@Generated(value = "header.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Header implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cat_ID = -100; // which catogery is selected


    public static void setCountries(Map<String, Integer> countries) {
        Header.countries = countries;
    }
    // this map to hold returned categories from data base
    // static block will be done one time "when the srever start"
    private static Map<String, Integer> countries;
    static {
        countries = new LinkedHashMap<String, Integer>();

        List<CategoryDto> cats = new DaoFactory().getDaoGatogory().listAllCatogries();

        countries.put("Categories", -100);
        for (CategoryDto cat : cats) {
            countries.put(cat.getName(), cat.getId());
        }
    }

    public Map<String, Integer> getCountriesInMap() {
        return countries;
    }


    //this will be called from ui when the first SelectOneMenu's value chang
    public void catogoryChanged(ValueChangeEvent e) {
        cat_ID = Integer.parseInt(e.getNewValue().toString());
        // @ Omar
        /* you can get catogery id from Session context or U can use it  Directly
        * as this bean is session scope and i prefer this
        * PLZ comment next lines if don't used
        * PLZ change this bean Scope if you used next lines
        */

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                        .getExternalContext()
                                                        .getSession(true);
        session.setAttribute("cat_ID", cat_ID);
        // this part not a good implmentation as redirect takes longer time also this exception need to
        // be raised to front end
        try {
            FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .redirect("products_list.jsf");
        } catch (IOException f) {
            f.printStackTrace();
        }

    }


    public void drd2Changed(ValueChangeEvent e) {
        // current selected value
        String e_value = e.getNewValue().toString();
        try {
            // multi if statement to detect which page i will go to it
            if (e_value.equals("Account")) {
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .getSessionMap()
                            .clear();
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .redirect("products_list.jsf");
            } else if (e_value.equals("Cart")) {
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .redirect("cart.jsf");
            } else if (e_value.equals("Our Appd")) {
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .redirect("Dose_Home.jsf");
            } else if (e_value.equals("Log Out")) {
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .redirect("signin.jsf");
            }
        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    public void setCat_ID(Integer cat_ID) {
        this.cat_ID = cat_ID;
    }

    public Integer getCat_ID() {
        return cat_ID;
    }


}
