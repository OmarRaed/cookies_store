package view.backing;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;

@ManagedBean(name = "backing_Dose_Home")
@RequestScoped
@Generated(value = "1Dose_Home.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Dose_Home {
    private HtmlCommandButton commandButton1;
    private HtmlCommandButton commandButton2;

    public void setCommandButton1(HtmlCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public HtmlCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCommandButton2(HtmlCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public HtmlCommandButton getCommandButton2() {
        return commandButton2;
    }
}
