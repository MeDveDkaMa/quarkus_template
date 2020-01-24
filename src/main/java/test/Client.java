package test;

import Beans.Role;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

//@Entity

public class Client extends PanacheEntity {

    public String name;
    public String adress;
    public String email;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Dish> dish;

    @ManyToOne
    @JsonbTransient
    public Role role;


}
