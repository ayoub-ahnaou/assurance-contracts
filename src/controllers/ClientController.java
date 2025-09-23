package controllers;

import models.Client;
import services.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientController {
    ClientService clientService = new ClientService();

    public void createClient(String id, String nom, String prenom, String email, String conseillerId) {
        Client client = new Client(id, nom, prenom, email, conseillerId);
        clientService.createClient(client);
    }

    public Optional<Client> searchClientById(String id) {
        Optional<Client> client = clientService.getAccount(id);
        if(client == null) return null;
        else return client;
    }

    public List<Client> getAllClientsSortedByLastName() {
        return clientService.getAccounts();
    }
}
