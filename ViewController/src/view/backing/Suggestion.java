package view.backing;

import com.team1.cookies.dao.SuggDao;

import com.team1.cookies.dao.SuggDaoImp;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

@ManagedBean(name = "backing_suggestion")
@RequestScoped
@Generated(value = "1suggestion.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Suggestion {
    String enteredSugg;

    public void setEnteredSugg(String enteredSugg) {
        this.enteredSugg = enteredSugg;
    }

    public String getEnteredSugg() {
        return enteredSugg;
    }

    public String uploadSugg() {
        SuggDao suggDao = new SuggDaoImp();

        try {
            //get the customer ID
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                            .getExternalContext()
                                                            .getSession(true);
            int customerId = (Integer) session.getAttribute("customerId");

            suggDao.saveSugg(customerId, enteredSugg);
        } catch (Exception e) {

        }

        return null;

    }
}
