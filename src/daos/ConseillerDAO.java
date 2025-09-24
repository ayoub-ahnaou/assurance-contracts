package daos;

import config.Database;
import models.Conseiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ConseillerDAO {
    private Map<String, Conseiller> conseillers = new HashMap<>();

    // CREATE ADVISOR
    public void addConseiller(Conseiller conseiller) {
        String sql = "INSERT INTO conseillers (id, nom, prenom, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, conseiller.getId());
            stmt.setString(2, conseiller.getNom());
            stmt.setString(3, conseiller.getPrenom());
            stmt.setString(4, conseiller.getEmail());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // GET ADVISOR BY ID
    public Conseiller getConseillerById(String id) {
        String sql = "SELECT * FROM conseillers WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Conseiller(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // GET ALL ADVISORS
    public List<Conseiller> getAllConseillers() {
        List<Conseiller> conseillers = new ArrayList<>();
        String sql = "SELECT * FROM conseillers";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                conseillers.add(new Conseiller(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conseillers;
    }

    // DELETE ADVISOR BY ID
    public void deleteConseiller(String id) {
        String sql = "DELETE FROM conseillers WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
