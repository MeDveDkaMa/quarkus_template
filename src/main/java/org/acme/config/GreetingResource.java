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


@Path("/hello")
public class GreetingResource {
    @Inject
    SantaClausService santaClausService;

    @Inject
    CustomerService customerService;


    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Customers helloPerson() {
        return customerService.helloPerson();
    }

    @GET
    @Path("/emma/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift SearchGift(@PathParam Integer id) {
        Gift entity = entityManager.find(Gift.class, id);
        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        return entity;
    }


    @Transactional
    @POST
    @Path("/AddGift3")
    @Produces(MediaType.APPLICATION_JSON)
    public void AddedGiftf(String disk) {
        santaClausService.createGift(disk);
    }


    @Transactional
    @POST
    @Path("/AddGift1")
    @Produces(MediaType.APPLICATION_JSON)
    public void AddedGift(Gift gift) {
        entityManager.persist(gift);
    }

    @Transactional
    @POST
    @Path("/AddGift2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Gift gift) {
        entityManager.persist(gift);
        return Response.ok(gift).status(201).build();
    }

    @POST
    @Path("/AddCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreatePerson(Customers customer) {
        customerService.CreatePerson(customer);
        return Response.ok().build();
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


