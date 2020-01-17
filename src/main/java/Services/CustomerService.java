package Services;

import Beans.Customers;
import Beans.Gift;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class CustomerService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public void createGift(String giftDescription) {
        Gift gift = new Gift();
        gift.setName(giftDescription);
        entityManager.persist(gift);
    }

    public Customers helloPerson() {
        return new Customers();
    }

    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public void CreatePerson(Customers customer) {
        entityManager.persist(customer);
//        return Response.ok().build();
    }


}