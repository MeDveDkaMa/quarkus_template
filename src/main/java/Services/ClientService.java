package Services;

import Beans.Client;
import Beans.Role;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@ApplicationScoped
public class ClientService {

    ClientService(){
    }

    public void addClient(Client clientIN) throws NoSuchAlgorithmException { //@FormParam String name, @FormParam Long clientId
        Client client = new Client();
        Role role = new Role();
        role.roleName = clientIN.getRole().getRoleName();
        role.persist();
        client.role = role;
        client.username = clientIN.getUsername();
        client.adress = clientIN.getAdress();
        client.email = clientIN.getEmail();
        client.password = doHash(clientIN.getPassword());
        client.persist();
    }


    public String doHash(String password) throws NoSuchAlgorithmException {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes){
                builder.append(String.format("%02X",b));
            }
        return builder.toString();
    }


    public Response login(Client clientIN) throws NoSuchAlgorithmException {
        Client findUser = Client.find("email", clientIN.getEmail()).firstResult();
        if (findUser == null){
            System.out.println("Пользователь не найден");
            return Response.ok().status(404).build();
        } else {
            if(doHash(clientIN.getPassword()).equalsIgnoreCase(findUser.getPassword())) { //12344
                System.out.println("Пароли совпали");
                Client clientResponse = new Client();
                clientResponse.password = doHash(clientIN.getPassword());
                clientResponse.email = clientIN.getEmail();
                return Response.ok(clientResponse).status(200).build();
            } else
                return Response.ok().status(404).build();
        }
    }


    public List<Client> GetClient() {
        return Client.listAll();
    }

    public List<Role> GetRole() {
        return Role.listAll();
    }

}
