package controllers;

import enums.TypeContrat;
import models.Contrat;
import services.ContratService;

import java.time.LocalDate;
import java.util.List;

public class ContratController {
    private ContratService contratService = new ContratService();

    public void addContrat(String id, LocalDate dateDebut, LocalDate dateFin, String description, TypeContrat typeContrat, String clientId) {
        Contrat contrat = new Contrat(id, dateDebut, dateFin, description, typeContrat, clientId);
        contratService.addContrat(contrat, clientId);
    }

    public Contrat getContratById(String id) {
        return contratService.getContratById(id);
    }

    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }

    public void deleteContrat(String id) {
        contratService.deleteContrat(id);
    }

    public List<Contrat> getContratsByClient(String clientId) {
        return contratService.getContratsByClient(clientId);
    }
}
