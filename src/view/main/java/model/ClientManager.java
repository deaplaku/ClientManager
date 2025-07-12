package model;

import java.util.ArrayList;
import java.util.List;

public class ClientManager {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client){
        clients.add(client);
    }

    public List<Client> findClientByKeyWord(String keyword){
        List<Client> searchedClients = new ArrayList<>();
        for(Client client : clients){
            if(client.getName().contains(keyword) || client.getSurname().contains(keyword))
                searchedClients.add(client);
        }
        return searchedClients;
    }

    public List<Client> getAllClients(){
        return clients;
    }
}
