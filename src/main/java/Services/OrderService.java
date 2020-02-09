package Services;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Client;
import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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

    public void createCart(Cart cartIN){
        Client client = Client.findById(cartIN.id);
        Cart cart = new Cart();
        cart.client=client;
        cart.persist();
    }

    public List<CartProduct> getAllOrders(){
      return CartProduct.listAll();
    }


    public List<CartProduct> getDishesInCart2(Cart cartIn){
        Cart cart = Cart.findById(cartIn.id);
        System.out.println(cart.cartProducts);
        return cart.cartProducts;
    }


    public List<Dish> GetDish() {
        return Dish.listAll();
    }

    public List<Cart> getCartID(Client clientIN) {
        Client client = Client.findById(clientIN.id);
        Cart cart = new Cart();
        cart.id = client.id;
        return Cart.listAll();
    }

    public List<Cart> getCartID2(Client clientIN) {
        Client client = Client.findById(clientIN.id);
        return client.getCarts();
    }


    public void addProductOrder(Dish[] dishes) {
        for (Dish value : dishes) {
            Dish dish = Dish.findById(value.id);
            CartProduct cartProduct = new CartProduct();
            cartProduct.setDish(dish);
            cartProduct.persist();
        }

    }

    public void addProductList(CartProduct[] cartProductIN) {
        Dish dish = Dish.findById(cartProductIN[0].getDish().id);
        Cart cart = Cart.findById(cartProductIN[0].getCart().id);
        CartProduct cartProduct = new CartProduct();
        cartProduct.dish = dish;
        cartProduct.cart = cart;
        cartProduct.count = cartProductIN[0].getCount();

    }

    public Response DeleteProductsCart(Cart id) {
        CartProduct.deleteByID(id);
        return Response.ok().status(201).build();
    }
}
