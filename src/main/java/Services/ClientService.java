package Services;

import Beans.Client;
import Beans.Role;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClientService {

    ClientService(){
    }

    public void addClient(@FormParam String name, @FormParam String  adress, @FormParam String email, @FormParam String roleUser,@FormParam String passwordUser) { //@FormParam String name, @FormParam Long clientId
        Client client = new Client();
        Role role = new Role();
        role.roleName = roleUser;
        role.persist();
        client.role = role;
        client.username = name;
        client.adress = adress;
        client.email = email;
        client.password = passwordUser;
        client.persist();
    }

    public List<Client> GetClient() {
        return Client.listAll();
    }

    public List<Role> GetRole() {
        return Role.listAll();
    }

}
