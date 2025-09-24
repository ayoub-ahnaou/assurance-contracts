package services;

import daos.ConseillerDAO;
import models.Conseiller;

import java.util.List;
import java.util.Optional;

public class ConseillerService {
    ConseillerDAO dao = new ConseillerDAO();

    public void addConseiller(Conseiller conseiller) {
        try {
            dao.addConseiller(conseiller);
            System.out.println("Conseiller ajouté avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout du conseiller", e);
        }
    }

    public Conseiller getConseillerById(String id) {
        try {
            return dao.getConseillerById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération du conseiller", e);
        }
    }

    public List<Conseiller> getAllConseillers() {
        try {
            return dao.getAllConseillers();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des conseillers", e);
        }
    }

    public void deleteConseiller(String id) {
        try {
            dao.deleteConseiller(id);
            System.out.println("Conseiller supprimé avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du conseiller", e);
        }
    }
}
