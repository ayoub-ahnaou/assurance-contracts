package services;

import daos.ClientDAO;
import models.Client;

import java.util.List;

public class ClientService {
    private ClientDAO dao = new ClientDAO();

    // CREATE
    public void createClient(Client client) {
        try {
            dao.addClient(client);
            System.out.println("Client added successfully: " + client.getId());
        } catch (Exception e) {
            System.err.println("Failed to add client: " + e.getMessage());
        }
    }

    // READ (one)
    public Client getClient(String id) {
        try {
            Client client = dao.getClientById(id);
            if (client == null) {
                System.out.println("Client not found with id: " + id);
            }
            return client;
        } catch (Exception e) {
            System.err.println("Failed to fetch client: " + e.getMessage());
            return null;
        }
    }

    // READ (all)
    public List<Client> getAllClients() {
        try {
            return dao.getAllClients();
        } catch (Exception e) {
            System.err.println("Failed to fetch clients: " + e.getMessage());
            return null;
        }
    }

    // DELETE
    public void deleteClient(String id) {
        try {
            dao.deleteClient(id);
            System.out.println("Client deleted successfully: " + id);
        } catch (Exception e) {
            System.err.println("Failed to delete client: " + e.getMessage());
        }
    }

    // EXTRA: get clients by conseiller
    public List<Client> getClientsByConseiller(String conseillerId) {
        try {
            return dao.getClientsByConseiller(conseillerId);
        } catch (Exception e) {
            System.err.println("Failed to fetch clients for conseiller: " + e.getMessage());
            return null;
        }
    }
}
