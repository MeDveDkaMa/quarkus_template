package Services;



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

//
//    public zzzzzzzzzzzzustomers[] GetCustomer() {
//        return entityManager.createNamedQuery("Customers.findAll", zzzzzzzzzzzzustomers.class).getResultList().toArray(new zzzzzzzzzzzzustomers[0]);
//    }

//    @Transactional
//    @Produces(MediaType.APPLICATION_JSON)
//    public void CreateCustomer(zzzzzzzzzzzzustomers customer) {
//        entityManager.persist(customer);
////        return Response.ok().build();
//    }


}