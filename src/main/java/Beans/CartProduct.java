package Beans;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;
//ссылка на вещь в заказе

@Entity
public class CartProduct extends PanacheEntity {

    public int count;

    @ManyToOne
   // @JsonbTransient
    public Cart cart;

    @ManyToOne
   // @JsonbTransient
    public Dish dish;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public static void deleteByID(Long id){
        delete("cart_id", id);
    }

    //    @OneToMany(mappedBy = "cartProduct", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonbTransient
//    public List<Dish> dishes;


}
