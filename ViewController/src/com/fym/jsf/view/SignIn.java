package com.fym.jsf.view;

import com.team1.cookies.bao.AccountBao;
import com.team1.cookies.bao.AccountBaoImp;
import com.team1.cookies.dto.CustomerDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import javax.validation.constraints.NotNull;

@ManagedBean(name = "sign_in")
@RequestScoped
public class SignIn {

    public final static int USER_NOT_FOUND = -10000;

    public SignIn() {
    }
    AccountBao account = new AccountBaoImp();
    CustomerDto customer = new CustomerDto();
    @NotNull(message = "Email can't be empty")

    private String email;


    @NotNull(message = "password can't be empty")

    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String submit() {

        customer.setEmail(this.getEmail());
        customer.setPassword(this.getPassword());

        int customerId = account.sign_in(customer);

        if (customerId != USER_NOT_FOUND) {

            //set the customer ID
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                            .getExternalContext()
                                                            .getSession(true);
            session.setAttribute("customerId", customerId);

            return "success";
        } else {

            return "signin.jsf";
        }

    }
}
