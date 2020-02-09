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

    @POST
    @RolesAllowed({"Admin"})
    @Path("dish/addDish")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDish(Dish dish) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
        dishesService.addDish(dish);
        return Response.ok().status(201).build();
    }

    @GET
    @RolesAllowed({"Admin","User"})
    @Path("dish/GetDish")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dish> GetDish() {
        return dishesService.GetDish();
    }


    @POST
    @RolesAllowed({"Admin"})
    @Path("dish/Delete")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response Delete(Dish id) {
        return dishesService.DeleteDish(id);
    }


}

