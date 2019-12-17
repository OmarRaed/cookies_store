package com.fym.jsf.view;

import com.team1.cookies.bao.AccountBao;
import com.team1.cookies.bao.AccountBaoImp;
import com.team1.cookies.dto.CustomerDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.validation.constraints.NotNull;

@ManagedBean(name = "sign_in")
@RequestScoped
public class SignIn {
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

        if (account.sign_in(customer)) {

            return "success";
        } else {

            return "signin.jsf";
        }

    }
}
