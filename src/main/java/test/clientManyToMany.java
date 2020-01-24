package test;

import Beans.Dish;
import Beans.Role;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

//@Entity
public class clientManyToMany extends PanacheEntity {

    public String name;
    public String adress;
    public String email;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonbTransient
    @JoinTable(name = "orderr",  joinColumns = @JoinColumn(name = "client_id"),inverseJoinColumns = @JoinColumn(name = "dish_id"))
    List<dishManyToMany> dishManyToManies;



}
