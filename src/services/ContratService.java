package services;

import daos.ContratDAO;
import enums.TypeContrat;
import models.Contrat;

import java.util.List;
import java.util.Optional;

public class ContratService {
    private ContratDAO dao = new ContratDAO();

    public void addContrat(Contrat contrat, String clientId) {
        try {
            dao.addContrat(contrat, clientId);
            System.out.println("Contrat ajouté avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout du contrat", e);
        }
    }

    // READ one
    public Contrat getContratById(String id) {
        try {
            Optional<Contrat> optionalContrat = Optional.ofNullable(dao.getContratById(id))
                    .orElseThrow(() -> new RuntimeException("Contrat not found with id: " + id));

            return new Contrat(
                    optionalContrat.get().getId(),
                    optionalContrat.get().getDateDebut(),
                    optionalContrat.get().getDateFin(),
                    optionalContrat.get().getMontant(),
                    optionalContrat.get().getDescription(),
                    (TypeContrat) optionalContrat.get().getTypeContratEnum());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // READ all
    public List<Contrat> getAllContrats() {
        try {
            return dao.getAllContrats();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des contrats", e);
        }
    }

    // DELETE
    public void deleteContrat(String id) {
        try {
            dao.deleteContrat(id);
            System.out.println("Contrat supprimé avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du contrat", e);
        }
    }

    // EXTRA: contrats by client
    public List<Contrat> getContratsByClient(String clientId) {
        try {
            return dao.getContratsByClient(clientId);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des contrats du client", e);
        }
    }
}
