package controllers;

import models.Client;
import services.ClientService;

public class ClientController {
    ClientService clientService = new ClientService();

    public void createClient(int id, String nom, String prenom, String email) {
        clientService.createClient(id, nom, prenom, email);
    }

    public void getAccount(int id) {
        Client client = clientService.getAccount(id);
        if(client == null) System.out.println("Client don't exist!");
        else System.out.println(client.toString());
    }

    public void getAccounts() {
        clientService.getAccounts();
    }
}
