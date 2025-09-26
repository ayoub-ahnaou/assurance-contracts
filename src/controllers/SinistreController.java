package controllers;

import enums.TypeSinistre;
import models.Sinistre;
import services.SinistreService;

import java.time.LocalDate;
import java.util.List;

public class SinistreController {
    private SinistreService sinistreService = new SinistreService();

    public void addSinistre(String id, LocalDate dateDebut, double montant, TypeSinistre typeSinistre, String contratId) {
        Sinistre sinistre = new Sinistre(id, dateDebut, montant, typeSinistre, contratId);
        sinistreService.addSinistre(sinistre);
    }

    public Sinistre getSinistreById(String id) {
        return sinistreService.getSinistreById(id);
    }

    public List<Sinistre> getAllSinistres() {
        return sinistreService.getAllSinistres();
    }

    public void deleteSinistre(String id) {
        sinistreService.deleteSinistre(id);
    }

    public List<Sinistre> getSinistresByContrat(String contratId) {
        return sinistreService.getSinistresByContrat(contratId);
    }

    public List<Sinistre> sortSinistreByAmount() {
        return sinistreService.sortSinistreByAmount();
    }

    public List<Sinistre> listSinistresBeforeDate(LocalDate date) {
        return sinistreService.listSinistresBeforeDate(date);
    }

    public List<Sinistre> listSinistresAboveCout(double montant) {
        return sinistreService.listSinistresAboveCout(montant);
    }

    public double couxTotauxDeSinistresByClientId(String id) {
        return sinistreService.couxTotauxDeSinistresByClientId(id);
    }
}
