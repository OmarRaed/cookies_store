package com.fym.jsf.view;

import com.team1.cookies.bao.AccountBao;
import com.team1.cookies.bao.AccountBaoImp;
import com.team1.cookies.dto.CustomerDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import javax.validation.constraints.NotNull;

@ManagedBean(name = "sign_up")
@RequestScoped
public class SignUp {
    public SignUp() {
    }
    AccountBao account = new AccountBaoImp();
    CustomerDto customer = new CustomerDto();
    @NotNull(message = "First name can't be empty")
    private String first_name;
    @NotNull(message = "last name can't be empty")
    private String last_name;
    @NotNull(message = "Email can't be empty")
    private String email;
    @NotNull(message = "password can't be empty")
    private String password;
    @NotNull(message = "confirm_password can't be empty")
    private String confirm_password;

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

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

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public String submit() {

        customer.setFirst_name(this.getFirst_name());
        customer.setLast_name(this.getLast_name());
        customer.setEmail(this.getEmail());

        customer.setPassword(this.getPassword());
        if (account.sign_up(customer)) {

            customer.setEmail(this.getEmail());
            customer.setPassword(this.getPassword());

            int customerId = account.sign_in(customer);
            
            //set the customer ID
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                            .getExternalContext()
                                                            .getSession(true);
            session.setAttribute("customerId", customerId);

            return "account";
        } else {

            return "signup.jsf";
        }

    }
}
