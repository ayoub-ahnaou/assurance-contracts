package controllers;

import models.Conseiller;
import services.ConseillerService;

import java.util.List;

public class ConseillerController {
    ConseillerService conseillerService = new ConseillerService();

    public void addConseiller(Conseiller conseiller) {
        conseillerService.addConseiller(conseiller);
    }

    public Conseiller getConseillerById(String id) {
        return conseillerService.getConseillerById(id);
    }

    public List<Conseiller> getAllConseillers() {
        return conseillerService.getAllConseillers();
    }

    public void deleteConseiller(String id) {
        conseillerService.deleteConseiller(id);
    }
}
