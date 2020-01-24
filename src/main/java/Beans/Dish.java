package Beans;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Dish extends PanacheEntity {

    public int price;
    public String name;
    public String composition;

    @ManyToOne
    @JsonbTransient
    public Client client;

}
