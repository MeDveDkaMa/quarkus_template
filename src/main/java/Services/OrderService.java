package Services;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderService {

    public OrderService() {
    }


    public void addOrder(@FormParam Long dishID, @FormParam Long orderID, @FormParam int cout) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
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

}
