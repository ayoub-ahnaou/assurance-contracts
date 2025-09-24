package daos;

import config.Database;
import models.Client;

import java.sql.*;
import java.util.*;

public class ClientDAO {
    private Map<String, Client> clients = new HashMap<>();

    // CREATE NEW RECORD
    public void addClient(Client client) {
        String sql = "INSERT INTO clients (id, nom, prenom, email, conseiller_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, client.getId());
            stmt.setString(2, client.getNom());
            stmt.setString(3, client.getPrenom());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getConseillerId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // GET ONE CLIENT
    public Client getClientById(String id) {
        String sql = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("conseiller_id")
                );
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // GET ALL CLIENTS
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Statement stmt = Database.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clients.add(new Client(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("conseiller_id")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    // DELETE A CLIENT BY ID
    public void deleteClient(String id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // GET ALL CLIENTS BY ADVISOR
    public List<Client> getClientsByConseiller(String conseillerId) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients WHERE conseiller_id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, conseillerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(new Client(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("conseiller_id")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
