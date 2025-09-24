package controllers;

import models.Client;
import services.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientController {
    ClientService clientService = new ClientService();

    public void addClient(Client client) {
        clientService.createClient(client);
    }

    public Client getClientById(String id) {
        return clientService.getClient(id);
    }

    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    public void deleteClient(String id) {
        clientService.deleteClient(id);
    }

    public List<Client> getClientsByConseiller(String conseillerId) {
        return clientService.getClientsByConseiller(conseillerId);
    }
}
