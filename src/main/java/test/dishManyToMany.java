package test;

import Beans.Client;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

//@Entity
public class dishManyToMany  extends PanacheEntity {

    public int price;
    public String name;
    public String composition;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonbTransient
    @JoinTable(name = "orderr",  joinColumns = @JoinColumn(name = "dish_id"),inverseJoinColumns = @JoinColumn(name = "client_id"))
    List<clientManyToMany> clientManyToManies;


}
