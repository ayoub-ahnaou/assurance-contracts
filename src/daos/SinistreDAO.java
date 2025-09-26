package daos;

import config.Database;
import enums.TypeSinistre;
import models.Sinistre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinistreDAO {
    private Map<String, Sinistre> sinistres = new HashMap<>();

    // CREATE
    public void addSinistre(Sinistre sinistre) {
        String sql = "INSERT INTO sinistres (id, dateDebut, montant, typeSinistre, contrat_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(sinistre.getId()));
            stmt.setTimestamp(2, Timestamp.valueOf(sinistre.getDateDebut().atStartOfDay()));
            stmt.setDouble(3, sinistre.getMontant());
            stmt.setString(4, sinistre.getTypeSinistreEnum().name());
            stmt.setString(5, sinistre.getContratId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // READ one
    public Sinistre getSinistreById(String id) {
        String sql = "SELECT * FROM sinistres WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Sinistre(
                        rs.getString("id"),
                        rs.getTimestamp("dateDebut").toLocalDateTime().toLocalDate(),
                        rs.getDouble("montant"),
                        TypeSinistre.valueOf(rs.getString("typeSinistre")),
                        rs.getString("contrat_id")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // READ all
    public List<Sinistre> getAllSinistres() {
        List<Sinistre> sinistres = new ArrayList<>();
        String sql = "SELECT * FROM sinistres";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sinistres.add(new Sinistre(
                        rs.getString("id"),
                        rs.getTimestamp("dateDebut").toLocalDateTime().toLocalDate(),
                        rs.getDouble("montant"),
                        TypeSinistre.valueOf(rs.getString("typeSinistre")),
                        rs.getString("contrat_id")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sinistres;
    }

    // DELETE
    public void deleteSinistre(String id) {
        String sql = "DELETE FROM sinistres WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // EXTRA: get sinistres by contrat
    public List<Sinistre> getSinistresByContrat(String contratId) {
        List<Sinistre> sinistres = new ArrayList<>();
        String sql = "SELECT * FROM sinistres WHERE contrat_id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, contratId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sinistres.add(new Sinistre(
                        rs.getString("id"),
                        rs.getTimestamp("dateDebut").toLocalDateTime().toLocalDate(),
                        rs.getDouble("montant"),
                        TypeSinistre.valueOf(rs.getString("typeSinistre")),
                        rs.getString("contrat_id")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sinistres;
    }
}
