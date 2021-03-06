package WEBResources;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Client;
import Beans.Dish;
import Services.OrderService;

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
    public Response addOrder(CartProduct cartProduct) {
        orderService.addToOrder(cartProduct);
        return Response.ok().status(201).build();
    }

    @POST
    @Path("orders/CreateOrder")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CreateOrder(Cart cart) {
        orderService.createCart(cart);
        return Response.ok().status(201).build();
    }

    @POST
    @Path("orders/GetOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartProduct> GetDish(Cart cart) {
        return orderService.getDishesInCart2(cart);
    }

//    @POST
//    @Path("orders/GetOrderByID")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Cart> GetDish(Client client) {
//        return orderService.getCartID(client);
//    }


    @POST
    @Path("orders/GetOrderByID")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartProduct> GetDish2(Client client) {
        return orderService.getDishesByID(client);
    }

//    @POST
//    @Path("orders/GetOrderByID")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<CartProduct> GetDish2(Cart cart) {
//        return orderService.getDishesByID(cart);
//    }


    @GET
    @Path("orders/GetOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartProduct> GetDish() {
        return orderService.getAllOrders();
    }


    @POST
    @Path("orders/Delete")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response Delete(Cart id) {
        return orderService.DeleteProductsCart(id);
    }


    @POST
    @Path("orders/GetCartID")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cart> GetCartID(Client client) {
        return orderService.getCartID2(client);
    }


    @POST
    @Transactional
    @Path("orders/addProductInOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductOrder(Dish[] dish)
    {
        orderService.addProductOrder(dish);
        return Response.ok().status(201).build();
    }

    @POST
    @Transactional
    @Path("orders/addProductList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(CartProduct[] cartProduct)
    {
        orderService.addProductList(cartProduct);
        return Response.ok().status(201).build();
    }



 }
