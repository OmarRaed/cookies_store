package view.backing;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import model.dto.ProductDto;
import model.dto.ProductsDao;
import model.dto.ProductsDaoImp;

@ManagedBean(name = "backing_products_list")
@RequestScoped
@Generated(value = "1products_list.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ProductsList {

    ProductsDao productDao = new ProductsDaoImp();
    private List<ProductDto> products;

    public ProductsList() {
    }

    @PostConstruct
    public void Init() {

        try {
            products = productDao.getAllProducts();
        } catch (Exception e) {
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                        .getExternalContext()
                                                        .getSession(true);
        //        String version = FacesContext.class.getPackage().getImplementationVersion();
              System.out.println("versionnnnnnnnnn :"+session.getAttribute("cat_ID"));

    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public String productSelected() {

        Map requestParams = FacesContext.getCurrentInstance()
                                        .getExternalContext()
                                        .getRequestParameterMap();
        String productId = (String) requestParams.get("productId");

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                        .getExternalContext()
                                                        .getSession(true);

        session.setAttribute("productId", productId);

        return "productDetails";

    }

}
