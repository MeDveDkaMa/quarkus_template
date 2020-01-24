package WEBResources;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Client;
import Beans.Dish;
import Services.OrderService;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Orders {

    @Inject
    OrderService orderService;

    @PUT
    @Path("orders/addOrder")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addOrder(@FormParam Long dishID, @FormParam Long orderID, @FormParam int cout) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
      orderService.addOrder(dishID,orderID,cout);
      return Response.ok().status(201).build();
    }

    public void createOrder(){
        Cart cart = new Cart();
        cart.persist();
    }

//    public void addToOrder(Dish dish){
//        addOrder(dish.id,);
//    }


}
