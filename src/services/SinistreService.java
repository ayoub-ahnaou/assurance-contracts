package services;

import daos.SinistreDAO;
import models.Sinistre;

import java.util.List;

public class SinistreService {
    private SinistreDAO sinistreDAO = new SinistreDAO();

    public void addSinistre(Sinistre sinistre, String contratId) {
        try {
            sinistreDAO.addSinistre(sinistre, contratId);
            System.out.println("Sinistre ajouté avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout du sinistre", e);
        }
    }

    public Sinistre getSinistreById(String id) {
        try {
            return sinistreDAO.getSinistreById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération du sinistre", e);
        }
    }

    public List<Sinistre> getAllSinistres() {
        try {
            return sinistreDAO.getAllSinistres();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des sinistres", e);
        }
    }

    public void deleteSinistre(String id) {
        try {
            sinistreDAO.deleteSinistre(id);
            System.out.println("Sinistre supprimé avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du sinistre", e);
        }
    }

    public List<Sinistre> getSinistresByContrat(String contratId) {
        try {
            return sinistreDAO.getSinistresByContrat(contratId);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des sinistres du contrat", e);
        }
    }
}
