package WEBResources;

import Beans.Client;
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
    public void addClient(@FormParam String name, @FormParam String  adress, @FormParam String email) { //@FormParam String name, @FormParam Long clientId
        Client client = new Client();
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

}
