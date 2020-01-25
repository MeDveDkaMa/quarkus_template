package Services;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Client;
import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderService {

    public OrderService() {
    }


    public void addToOrder(@FormParam Long dishID, @FormParam Long orderID, @FormParam int cout) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        Dish dish = Dish.findById(dishID);
        if (dish == null) {
            return;
        }

        Cart cart = Cart.findById(orderID);
        if (cart == null) {
            return;
        }

        CartProduct cartProduct = new CartProduct();
        cartProduct.cart = cart;
        cartProduct.dish = dish;
        cartProduct.count = cout;
        cartProduct.persist();
    }

    public void createCart(@FormParam Long clientID){
        Client client = Client.findById(clientID);
        Cart cart = new Cart();
        cart.client=client;
        cart.persist();
    }

    public List<CartProduct> getDishesInCart(){
      return CartProduct.listAll();
    }

    public List<Dish> GetDish() {
        return Dish.listAll();
    }

}
