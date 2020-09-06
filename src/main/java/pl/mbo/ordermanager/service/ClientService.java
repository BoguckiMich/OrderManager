package pl.mbo.ordermanager.service;

import org.springframework.stereotype.Service;
import pl.mbo.ordermanager.model.Client;
import pl.mbo.ordermanager.repository.ClientRepostiory;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepostiory clientRepostiory;

    public ClientService(ClientRepostiory clientRepostiory) {
        this.clientRepostiory = clientRepostiory;
    }


    public boolean createClient(Client client) {
        Client client1 = Client.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .town(client.getTown())
                .address(client.getAddress())
                .phone(client.getPhone())
                .build();
        clientRepostiory.save(client1);

        return false;
    }

    public List<Client> findAllClients() {
        return clientRepostiory.findAll();
    }
}
