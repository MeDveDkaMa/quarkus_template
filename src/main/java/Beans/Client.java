package Beans;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity

public class Client extends PanacheEntity {

    public String username;
    public String adress;
    public String email;
    public String password;



    @ManyToOne
    @JsonbTransient
    public Role role;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Cart> carts;


}
