package services;

import daos.ClientDAO;
import models.Client;

import java.util.List;

public class ClientService {
    private ClientDAO dao = new ClientDAO();

    public void createClient(int id, String nom, String prenom, String email) {
        Client client = new Client(id, nom, prenom, email);
        dao.createClient(client);
    }

    public Client getAccount(int id) {
        return dao.getAccount(id);
    }

    public List<Client> getAccounts() {
        return dao.getAccounts();
    }
}
