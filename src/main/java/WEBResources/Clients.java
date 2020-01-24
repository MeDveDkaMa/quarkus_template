package WEBResources;

import Beans.Client;
import Beans.Role;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class Clients {

    @PUT
    @Path("client/add")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addClient(@FormParam String name, @FormParam String  adress, @FormParam String email, @FormParam String roleUser) { //@FormParam String name, @FormParam Long clientId
        Client client = new Client();
        Role role = new Role();
        role.roleName = roleUser;
        role.persist();
        client.role = role;
        client.name = name;
        client.adress = adress;
        client.email = email;
        client.persist();
    }

    @GET
    @Path("client/GetClient")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> GetClient() {
        return Client.listAll();
    }

    @GET
    @Path("client/GetClientRole")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> GetRole() {
        return Role.listAll();
    }

}
