package view.backing;

import com.team1.cookies.dao.DaoFactory;
import com.team1.cookies.dto.CategoryDto;

import java.io.Serializable;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.event.ValueChangeEvent;

import javax.swing.JOptionPane;

@ManagedBean(name = "backing_header")
@RequestScoped
@Generated(value = "1header.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Header implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cat_Name= "Products";  // which one is selected

    private static Map<String,Integer> countries;
    static {
        countries = new LinkedHashMap<String,Integer>();
        //countries.put("English",1); 
       // countries.put("Chinese",2);
        List<CategoryDto> cats = new DaoFactory().getDaoGatogory().listAllCatogries();
       
        for (CategoryDto cat :cats)
        {
            countries.put(cat.getName(), cat.getId());
        }
    }

    public Map<String,Integer> getCountriesInMap() {
        return countries;
    }


    @PostConstruct
       public void init() {
           //cats = new DaoFactory().getDaoGatogory().listAllCatogries();
           }
    
//+++++++++++++++++++++++++++
    public void catogoryChanged(ValueChangeEvent e){
		//assign new value to localeCode
		cat_Name = e.getNewValue().toString();
                JOptionPane.showConfirmDialog(null, cat_Name);
	}
    //++++++++++++++++++++++++

   


    public void setCat_Name(String cat_Name) {
        this.cat_Name = cat_Name;
    }

    public String getCat_Name() {
        return cat_Name;
    }


}
