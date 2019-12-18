package view.backing;

import com.team1.cookies.dao.CartDao;
import com.team1.cookies.dao.CartDaoImp;
import com.team1.cookies.dto.CartDto;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dto.ProductsDao;
import model.dto.ProductsDaoImp;
import model.dto.ProductDto;

import org.primefaces.component.inputnumber.InputNumber;

@ManagedBean(name = "backing_product")
@RequestScoped
@Generated(value = "1product.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Product {

    private ProductDto product;
    private int quantity ;
    @PostConstruct
    public void init() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                                                        .getExternalContext()
                                                        .getSession(false);
        Integer productId = Integer.parseInt((String) session.getAttribute("productId"));
        
        ProductsDao productDao = new ProductsDaoImp() ;
        product = productDao.getProductById(productId) ;
        
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public ProductDto getProduct() {
        return product;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public String addProductToCart(){
        
        //create a new CartDto object
        CartDto cart = new CartDto() ;        
        
        //get the customer ID
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        int customerId = (Integer) session.getAttribute("customerId");
        session.setAttribute("customerId", 2);        
        
        System.out.println("QUANTITY : " + quantity);
        
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        quantity = Integer.parseInt((String) request.getParameter("productQuantity"));
        
        System.out.println("QUANTITY : " + request.getParameter("productQuantity"));

        
        //set cart details
        cart.setPrice(product.getSmallPrice() * quantity);
        cart.setProductId(product.getId());
        cart.setQuantity(quantity);
        cart.setCustomerId(2);

        //add this to the cart
        CartDao  cartDao = new CartDaoImp() ;
        cartDao.addToCart(cart);
        
        return "goToCart";
        
    }

}
