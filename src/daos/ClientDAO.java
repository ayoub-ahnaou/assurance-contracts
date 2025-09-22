package daos;

import models.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAO {
    private Map<Integer, Client> clients = new HashMap<>();

    // insert client into database
    public void createClient(Client client) {}

    // get one account details
    public Client getAccount(int id) {
        return clients.get(id);
    }

    // get all accounts
    public List<Client> getAccounts() {
        return new ArrayList<>(clients.values());
    }
}
