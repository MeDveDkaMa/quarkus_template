package WEBResources;

import Beans.Client;
import Beans.Role;
import Services.ClientService;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Path("")
public class Clients {

    @Inject
    ClientService clientService;

    @POST
    @Path("client/add")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClient(Client client) throws NoSuchAlgorithmException { //@FormParam String name, @FormParam Long clientId
      clientService.addClient(client);
      return Response.ok().status(201).build();
    }

    @GET
    @Path("client/GetClient")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> GetClient() {
        return clientService.GetClient();
    }

    @GET
    @Path("client/GetClientRole")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> GetRole() {
        return clientService.GetRole();
    }

}
