package org.acme.config;

import Beans.Customers;
import Beans.Gift;
import Services.CustomerService;
import Services.SantaClausService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.persistence.EntityManager;
import java.util.List;


@Path("")
public class GreetingResource {
    @Inject
    SantaClausService santaClausService;

    @Inject
    CustomerService customerService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/gift/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift SearchGift(@PathParam Integer id) {
        return santaClausService.SearchGift(id);
    }

    @Transactional
    @POST
    @Path("/gift/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateGift(Gift gift) {
        santaClausService.createGift(gift);
        return Response.ok(gift).status(201).build();
    }

    @POST
    @Path("/customer/AddCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreatePerson(Customers customer) {
        customerService.CreatePerson(customer);
        return Response.ok().status(201).build();
    }

    @GET
    @Path("/customer/GetCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customers[] GetCustomer() {
        return customerService.GetCustomer();
    }

}



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

