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
    @JsonbTransient
    public Cart cart;

    @ManyToOne
    @JsonbTransient
    public Dish dish;


//    @OneToMany(mappedBy = "cartProduct", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonbTransient
//    public List<Dish> dishes;


}
