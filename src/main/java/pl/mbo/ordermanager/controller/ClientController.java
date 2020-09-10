package pl.mbo.ordermanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.mbo.ordermanager.model.Client;
import pl.mbo.ordermanager.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public void createClient(@RequestBody Client client) {
        boolean success = clientService.createClient(client);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.findAllClients();
    }
}
