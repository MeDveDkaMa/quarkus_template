package Beans;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;


@Entity
public class Dish extends PanacheEntity {

    public int price;
    public String name;
    public String composition;


//    @ManyToOne
//    @JsonbTransient
//    public CartProduct cartProduct;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonbTransient
    public List<CartProduct> cartProducts;

}
