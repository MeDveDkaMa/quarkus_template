package Services;

import Beans.Customers;
import Beans.Gift;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;


@ApplicationScoped
public class SantaClausService {
    @Inject
    EntityManager entityManager;

    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public void createGift(Gift gift) {
        entityManager.persist(gift);
    }

    public Gift SearchGift(@PathParam Integer id) {
        Gift entity = entityManager.find(Gift.class, id);
        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        return entity;
    }



}