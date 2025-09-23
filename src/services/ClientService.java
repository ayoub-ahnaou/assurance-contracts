package services;

import daos.ClientDAO;
import models.Client;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private ClientDAO dao = new ClientDAO();

    public void createClient(Client client) {
        if(client.getNome() == null || client.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nom required..");
        }
        if(client.getPrenom() == null || client.getPrenom().isEmpty()) {
            throw new IllegalArgumentException("Prenom required..");
        }
        if(client.getEmail() == null || client.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email required..");
        }
        // check for conseillerId existance in db before inserting
        // search for it by conseillerDAO
        dao.createClient(client);
    }

    public Optional<Client> getAccount(String id) {
        return dao.getAccount(id);
    }

    public List<Client> getAccounts() {
        return dao.getAccounts();
    }
}
