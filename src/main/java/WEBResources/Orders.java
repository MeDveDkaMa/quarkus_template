package WEBResources;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Client;
import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("")
public class Orders {

    @PUT
    @Path("orders/addOrder")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addOrder(@FormParam Long dishID, @FormParam Long orderID, @FormParam int cout) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        createOrder();
        Dish dish = Dish.findById(dishID);
//        if (dish == null) {
//            return;
//        }

        Cart cart = Cart.findById(orderID);
//        if (cart == null) {
//            return;
//        }

        CartProduct cartProduct = new CartProduct();
        cartProduct.cart = cart;
        cartProduct.dish = dish;
        cartProduct.count = cout;
        cartProduct.persist();
    }

    public void createOrder(){
        Cart cart = new Cart();
        cart.persist();
    }

//    public void addToOrder(Dish dish){
//        addOrder(dish.id,);
//    }


}
