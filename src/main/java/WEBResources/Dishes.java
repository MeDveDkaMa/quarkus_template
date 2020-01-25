package WEBResources;

import Beans.*;

import Services.DishesService;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Path("")
public class Dishes {

    @Inject
    DishesService dishesService;

    @PUT
    @RolesAllowed({"admin","user"})
    @Path("dish/addDish")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addDish(@FormParam String name, @FormParam String composition, @FormParam int price) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        dishesService.addDish(name,composition,price);
        return Response.ok().status(201).build();
    }

    @GET
    @Path("dish/GetDish")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dish> GetDish() {
        return dishesService.GetDish();
    }


}


//    @Transactional
//    @POST
//    @Path("/customer/CreateOrder")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response CreatePerson() {
//        Client client = new Client();
//        client.setEmail("TestEmail");
//        client.setAdress("9May");
//        client.setName("Александр Бирюлев");
//        Dish dish = new Dish();
//        dish.setName("суп");
//        dish.setPrice(231);
//        Set<Dish> dishes = new HashSet<>();
//        dishes.add(dish);
//        dish.
//        client.persist();
//
//        return Response.ok().status(201).build();
//    }
//
//
//
//
//
//    @Transactional
//    @POST
//    @Path("/customer/CreatePerson")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response CreateOrder(Client client) {
////        client.setDishes(dishesS);
////        client.persist();
////        dishesS.clear();
//////        client.persist();
//////        dishes.clear();
//        return Response.ok().status(201).build();
//    }
//
//    @Transactional
//    @POST
//    @Path("/customer/CreatePerson3")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response CreateOrder3(Dish dish) {
//        Client client = new Client();
//        System.out.println(dish.name);
////        Set<Dish> dishes = new HashSet<>();
////        client.setDish(dishes);
//        client.addDish(dish);
//        client.persist();
//        return Response.ok().status(201).build();
//    }
//
//
//    @Transactional
//    @POST
//    @Path("/customer/CreatePerson4")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response CreateOrder4(Client client) {
//        Dish dish = new Dish(client);
//        System.out.println(dish.getName());
//        dish.persist();
//        //client.addDish(dish);
//        client.persist();
//        return Response.ok().status(201).build();
//    }


//    @Transactional
//    @POST
//    @Path("/customer/CreateOrder2")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response CreateOrder(Dish dish) {
//        dishesS.add(dish);
//        return Response.ok().status(201).build();
//    }
//






//    @GET
//    @Path("/customer/GetCustomer")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Customers[] GetCustomer() {
//        return customerService.GetCustomer();
//    }








//    @GET
//    @Path("/testHello1")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response test(){
//        Map<String,Object> result = new HashMap<>();
//        result.put("Hello", "World");
//        result.put("key", "Value");
//        return Response.ok(result).build();
//    }

//    @Transactional
//    @POST
//    @Path("/AddGift1")
//    @Produces(MediaType.APPLICATION_JSON)
//    public void AddedGift(Gift gift) {
//        entityManager.persist(gift);
//    }

