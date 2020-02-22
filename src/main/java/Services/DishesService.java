package Services;

import Beans.Cart;
import Beans.CartProduct;
import Beans.Dish;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
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

    public Response DeleteDish(Dish dish) {
        Dish.deleteByID(dish);
        return Response.ok().status(201).build();
    }
}
