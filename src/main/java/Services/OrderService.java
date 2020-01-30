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


    public void addToOrder(CartProduct cartProductIN) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        Dish dish = Dish.findById(cartProductIN.getDish().id);
        if (dish == null) {
            System.out.println("DISH NULL");
            return;
        }

        Cart cart = Cart.findById(cartProductIN.getCart().id);
        if (cart == null) {
            System.out.println("CART NULL");
            return;
        }

        CartProduct cartProduct = new CartProduct();
        cartProduct.cart = cart;
        cartProduct.dish = dish;
        cartProduct.count = cartProductIN.count;
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
