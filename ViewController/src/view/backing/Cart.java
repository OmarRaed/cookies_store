package view.backing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;

import model.dao.CartDao;

import model.dao.CartDaoImp;

import model.dto.CartDto;

@ManagedBean(name = "backing_cart")
@RequestScoped
@Generated(value = "1cart.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Cart {

    private CartDao cartDao = new CartDaoImp();
    private int totalPrice = 0;
    private HtmlDataTable dataTable1;
    private HtmlOutputText outputText1;

    private HtmlForm form2;
    private List<CartDto> cartList;
    private HtmlDataTable dataTable2;
    private HtmlCommandButton checkoutButton;

    @PostConstruct
    public void init() {
        cartList = cartDao.getCart(1);
        try{
        for (CartDto cart : cartList)
            totalPrice += cart.getPrice();
        }catch(NullPointerException e){
            
        }
        
    }

    public void setCheckoutButton(HtmlCommandButton checkoutButton) {
        this.checkoutButton = checkoutButton;
    }

    public HtmlCommandButton getCheckoutButton() {
        return checkoutButton;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setCartList(List<CartDto> cartList) {
        this.cartList = cartList;
    }

    public List<CartDto> getCartList() {
        return cartList;
    }

    public void setForm2(HtmlForm form2) {
        this.form2 = form2;
    }

    public HtmlForm getForm2() {
        return form2;
    }

    public void setDataTable1(HtmlDataTable dataTable1) {
        this.dataTable1 = dataTable1;
    }

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setOutputText1(HtmlOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }


    public void setDataTable2(HtmlDataTable dataTable2) {
        this.dataTable2 = dataTable2;
    }

    public HtmlDataTable getDataTable2() {
        return dataTable2;
    }
}
