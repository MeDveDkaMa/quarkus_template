package WEBResources;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Client;
import Beans.Dish;
import Services.OrderService;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("")
public class Orders {

    @Inject
    OrderService orderService;

    @POST
    @Path("orders/addToOrder")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(CartProduct cartProduct) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        orderService.addToOrder(cartProduct);
        return Response.ok().status(201).build();
    }

    @PUT
    @Path("orders/CreateOrder")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response CreateOrder(@FormParam Long clientID) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        orderService.createCart(clientID);
        return Response.ok().status(201).build();
    }

    @GET
    @Path("orders/GetOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartProduct> GetDish() {
        return orderService.getDishesInCart();
    }




}
