package view.backing;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;

import javax.mail.Address;

import model.dao.AccountDao;

import model.dao.AccountDaoImp;

import model.dto.AccountDto;

@ManagedBean(name = "backing_account")
@RequestScoped
@Generated(value = "laccount.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Account {
    private HtmlForm form1;
    private HtmlInputText firstName, lastName, address ,mobile;
    private HtmlCommandButton saveButton;

    public void setFirstName(HtmlInputText FirstName) {
        this.firstName = FirstName;
    }

    public HtmlInputText getFirstName() {
        return firstName;
    }

    public void setLastName(HtmlInputText LastName) {
        this.lastName = LastName;
    }

    public HtmlInputText getLastName() {
        return lastName;
    }


    public void setAddress(HtmlInputText Address) {
        this.address = Address;
    }

    public HtmlInputText getAddress() {
        return address;
    }

    public void setMobile(HtmlInputText Mobile) {
        this.mobile = Mobile;
    }

    public HtmlInputText getMobile() {
        return mobile;
    }

    public void setSaveButton(HtmlCommandButton SaveButton) {
        this.saveButton = SaveButton;
    }

    public HtmlCommandButton getSaveButton() {
        return saveButton;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }
    public boolean saveAccount(){
        AccountDao accountDao = new AccountDaoImp();
        AccountDto accountDto = new AccountDto() ;
        
        accountDto.setFirstName(firstName.getValue().toString());
        accountDto.setLastName(lastName.getValue().toString());
        accountDto.setAddress(address.getValue().toString());
        accountDto.setMobile(mobile.getValue().toString());
        accountDto.setId(1);
        
        if(accountDao.updateUser(accountDto)){
            System.out.println("yes");}
        else{System.out.println("no");}
        return true;
    }

}
