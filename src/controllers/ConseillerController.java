package controllers;

import models.Conseiller;
import services.ConseillerService;

public class ConseillerController {
    ConseillerService conseillerService = new ConseillerService();

    public void createConseiller(String id, String nom, String prenom, String email) {
        Conseiller conseiller = new Conseiller(id, nom, prenom, email);
        conseillerService.createConseiller(conseiller);
    }
}
