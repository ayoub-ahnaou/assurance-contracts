package views;

import controllers.ConseillerController;
import models.Conseiller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ConseillerView {
    ConseillerController controller = new ConseillerController();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Gestion des Conseillers =====");
            System.out.println("1. Ajouter un conseiller");
            System.out.println("2. Afficher un conseiller par ID");
            System.out.println("3. Afficher tous les conseillers");
            System.out.println("4. Supprimer un conseiller");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consomme le newline

            switch (choice) {
                case 1:
                    addConseiller();
                    break;
                case 2:
                    viewConseillerById();
                    break;
                case 3:
                    viewAllConseillers();
                    break;
                case 5:
                    deleteConseiller();
                    break;
                case 0:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Option invalide, réessayez.");
                    break;
            }
        }
    }

    private void addConseiller() {
        String id = UUID.randomUUID().toString();
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Conseiller conseiller = new Conseiller(id, nom, prenom, email);
        controller.addConseiller(conseiller);
    }

    private void viewConseillerById() {
        System.out.print("ID du conseiller: ");
        String id = scanner.nextLine();

        Conseiller c = controller.getConseillerById(id);
        if (c != null) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nom: " + c.getNom());
            System.out.println("Prénom: " + c.getPrenom());
            System.out.println("Email: " + c.getEmail());
        } else {
            System.out.println("Conseiller introuvable !");
        }
    }

    private void viewAllConseillers() {
        List<Conseiller> conseillers = controller.getAllConseillers();
        if (conseillers != null && !conseillers.isEmpty()) {
            for (Conseiller c : conseillers) {
                System.out.println(c.getId() + " - " + c.getNom() + " " + c.getPrenom() + " (" + c.getEmail() + ")");
            }
        } else {
            System.out.println("Aucun conseiller trouvé.");
        }
    }

    private void deleteConseiller() {
        System.out.print("ID du conseiller à supprimer: ");
        String id = scanner.nextLine();

        controller.deleteConseiller(id);
    }
}
