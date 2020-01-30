package Services;

import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DishesService {

    public DishesService() {
    }

    public void addDish(Dish dishIN) {
        Dish dish = new Dish();
        dish.name = dishIN.getName();
        dish.composition = dishIN.getComposition();
        dish.price = dishIN.getPrice();
        dish.persist();

    }

    public List<Dish> GetDish() {
        return Dish.listAll();
    }

}
