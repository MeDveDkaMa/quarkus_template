package test;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


//@Entity
public class Dish extends PanacheEntity {

    public int price;
    public String name;
    public String composition;

    @ManyToOne
    @JsonbTransient
    public Client client;

}
