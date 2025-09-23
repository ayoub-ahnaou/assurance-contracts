package daos;

import config.Database;
import models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ClientDAO {
    private Map<String, Client> clients = new HashMap<>();

    // insert client into database
    public void createClient(Client client) {
        try {
            Connection connection = Database.getConnection();
            String sql = "INSERT INTO clients (id, nom, prenom, email, conseiller_id) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, client.getId());
            stm.setString(2, client.getNome());
            stm.setString(3, client.getPrenom());
            stm.setString(4, client.getEmail());
            stm.setString(5, client.getConseiller_id());

            stm.executeUpdate();
            System.out.println("Client created...");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // get one account details
    public Optional<Client> getAccount(String id) {
        return Optional.of(clients.get(id));
    }

    // get all accounts
    public List<Client> getAccounts() {
        return new ArrayList<>(clients.values());
    }
}
