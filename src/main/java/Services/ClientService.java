package Services;

import Beans.Client;
import Beans.Role;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
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


    public void login(){

    }


    public List<Client> GetClient() {
        return Client.listAll();
    }

    public List<Role> GetRole() {
        return Role.listAll();
    }

}
