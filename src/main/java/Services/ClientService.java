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

    public void addClient(Client clientIN) { //@FormParam String name, @FormParam Long clientId
        Client client = new Client();
        Role role = new Role();
        role.roleName = clientIN.getRole().getRoleName();
        role.persist();
        client.role = role;
        client.username = clientIN.getUsername();
        client.adress = clientIN.getAdress();
        client.email = clientIN.getEmail();
        client.password = clientIN.getPassword();
        client.persist();
    }

    public List<Client> GetClient() {
        return Client.listAll();
    }

    public List<Role> GetRole() {
        return Role.listAll();
    }

}
