package test;

import Beans.Client;
import Beans.Dish;
import Beans.Role;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import test.clientManyToMany;
import test.dishManyToMany;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class TestResponses {

    @PUT
    @Path("test/add")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addClient(@FormParam String name, @FormParam String  adress, @FormParam String email, @FormParam String roleUser) { //@FormParam String name, @FormParam Long clientId
        clientManyToMany client = new clientManyToMany();
        client.name = name;
        client.adress = adress;
        client.email = email;
        client.persist();
    }

    @PUT
    @Path("test/addDish")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDish(@FormParam String name, @FormParam String composition, @FormParam int price) { //@FormParam String name, @FormParam Long clientId
        dishManyToMany dish = new dishManyToMany();
        clientManyToMany clientManyToMany = new clientManyToMany();
        dish.name = name;
        dish.composition = composition;
        dish.price = price;
        dish.persist();
    }

    @PUT
    @Path("test/addOrder")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addOrder(@FormParam Long clientId,@FormParam Long dishId) { //@FormParam String name, @FormParam Long clientId
       clientManyToMany clientManyToMany1 =  new clientManyToMany();
       dishManyToMany dishManyToMany1 = new dishManyToMany();
       clientManyToMany1.id = clientId;
       dishManyToMany1.id = dishId;
       dishManyToMany1.persist();

    }

    @GET
    @Path("test/GetClient")
    @Produces(MediaType.APPLICATION_JSON)
    public List<clientManyToMany> GetClient() {
        return clientManyToMany.listAll();
    }


}
