package Services;

import Beans.Client;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientHandler {

    ClientHandler(){

    }

    public void addOrder(String name, String adress,String email){
        Client client = new Client();
        client.name = name;
        client.adress = adress;
        client.email = email;
        client.persist();
    }

}
