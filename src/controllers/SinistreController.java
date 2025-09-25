package controllers;

import enums.TypeSinistre;
import models.Sinistre;
import services.SinistreService;

import java.time.LocalDate;
import java.util.List;

public class SinistreController {
    private SinistreService sinistreService = new SinistreService();

    public void addSinistre(String id, LocalDate dateDebut, TypeSinistre typeSinistre, String contratId) {
        Sinistre sinistre = new Sinistre(id, dateDebut, typeSinistre);
        sinistreService.addSinistre(sinistre, contratId);
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
}
