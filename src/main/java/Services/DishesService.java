package Services;

import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DishesService {

    public DishesService() {
    }

    public void addDish(@FormParam String name, @FormParam String composition, @FormParam int price) { //@FormParam String name, @FormParam String composition, @FormParam int price, @FormParam Long clientId
//        Client client = Client.findById(clientId);
//        if (client == null) {
//            return;
//        }

        Dish dish = new Dish();
        dish.name = name;
        dish.composition = composition;
        dish.price = price;
//        dish.client = client;
        dish.persist();

    }

    public List<Dish> GetDish() {
        return Dish.listAll();
    }

}
