package daos;

import config.Database;
import enums.TypeContrat;
import models.Client;
import models.Contrat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

public class ContratDAO {
    private Map<String, Contrat> contrats = new HashMap<>();

    // CREATE
    public void addContrat(Contrat contrat, String clientId) {
        String sql = "INSERT INTO contrats (id, dateDebut, dateFin, description, typeContrat, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(contrat.getId()));
            stmt.setTimestamp(2, Timestamp.valueOf(contrat.getDateDebut().atStartOfDay()));
            stmt.setTimestamp(3, Timestamp.valueOf(contrat.getDateFin().atStartOfDay()));
            stmt.setString(4, contrat.getDescription());
            stmt.setString(5, contrat.getTypeContratEnum().name());
            stmt.setString(6, clientId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // READ one
    public Optional<Contrat> getContratById(String id) {
        String sql = "SELECT * FROM contrats WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Contrat(
                        rs.getString("id"),
                        rs.getTimestamp("dateDebut").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("dateFin").toLocalDateTime().toLocalDate(),
                        rs.getString("description"),
                        TypeContrat.valueOf(rs.getString("typeContrat"))
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // READ all
    public List<Contrat> getAllContrats() {
        List<Contrat> contrats = new ArrayList<>();
        String sql = "SELECT * FROM contrats";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                contrats.add(new Contrat(
                        rs.getString("id"),
                        rs.getTimestamp("dateDebut").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("dateFin").toLocalDateTime().toLocalDate(),
                        rs.getString("description"),
                        TypeContrat.valueOf(rs.getString("typeContrat"))
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return contrats;
    }

    // DELETE
    public void deleteContrat(String id) {
        String sql = "DELETE FROM contrats WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // EXTRA: get contrats by client
    public List<Contrat> getContratsByClient(String clientId) {
        List<Contrat> contrats = new ArrayList<>();
        String sql = "SELECT * FROM contrats WHERE client_id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, clientId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                contrats.add(new Contrat(
                        rs.getString("id"),
                        rs.getTimestamp("dateDebut").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("dateFin").toLocalDateTime().toLocalDate(),
                        rs.getString("description"),
                        TypeContrat.valueOf(rs.getString("typeContrat"))
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return contrats;
    }
}
