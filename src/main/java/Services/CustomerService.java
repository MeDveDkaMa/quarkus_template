package Services;

import Beans.Customers;
import Beans.Gift;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class CustomerService {
    @Inject
    EntityManager entityManager;


    public Customers[] GetCustomer() {
        return entityManager.createNamedQuery("Customers.findAll",Customers.class).getResultList().toArray(new Customers[0]);
    }

    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public void CreateCustomer(Customers customer) {
        entityManager.persist(customer);
//        return Response.ok().build();
    }


}