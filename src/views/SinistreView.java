package views;

import controllers.SinistreController;
import enums.TypeSinistre;
import models.Sinistre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class SinistreView {
    private SinistreController controller = new SinistreController();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Gestion des Sinistres =====");
            System.out.println("1. Ajouter un sinistre");
            System.out.println("2. Afficher un sinistre par ID");
            System.out.println("3. Afficher tous les sinistres");
            System.out.println("4. Supprimer un sinistre");
            System.out.println("5. Afficher les sinistres d'un contrat");
            System.out.println("6. Trie sinistres par montant");
            System.out.println("0. Retour");
            System.out.print("Choisissez une option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addSinistre();
                    break;
                case 2:
                    viewSinistreById();
                    break;
                case 3:
                    viewAllSinistres();
                    break;
                case 4:
                    deleteSinistre();
                    break;
                case 5:
                    viewSinistresByContrat();
                    break;
                case 0:
                    System.out.println("Retour au menu principal...");
                    return;
                default:
                    System.out.println("Option invalide, réessayez.");
                    break;
            }
        }
    }

    private void addSinistre() {
        String id = UUID.randomUUID().toString();

        System.out.print("Date de début (yyyy-MM-dd): ");
        LocalDate dateDebut = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Type de sinistre (ACCIDENT_DE_VOITURE, ACCIDENT_DE_MAISON, MALADIE): ");
        TypeSinistre type = TypeSinistre.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("ID du contrat: ");
        String contratId = scanner.nextLine();

        controller.addSinistre(id, dateDebut, type, contratId);
    }

    private void viewSinistreById() {
        System.out.print("ID du sinistre: ");
        String id = scanner.nextLine();

        Sinistre s = controller.getSinistreById(id);
        if (s != null) {
            printSinistre(s);
        } else {
            System.out.println("Sinistre introuvable !");
        }
    }

    private void viewAllSinistres() {
        List<Sinistre> sinistres = controller.getAllSinistres();
        if (sinistres != null && !sinistres.isEmpty()) {
            sinistres.forEach(this::printSinistre);
        } else {
            System.out.println("Aucun sinistre trouvé.");
        }
    }

    private void deleteSinistre() {
        System.out.print("ID du sinistre à supprimer: ");
        String id = scanner.nextLine();

        controller.deleteSinistre(id);
    }

    private void viewSinistresByContrat() {
        System.out.print("ID du contrat: ");
        String contratId = scanner.nextLine();

        List<Sinistre> sinistres = controller.getSinistresByContrat(contratId);
        if (sinistres != null && !sinistres.isEmpty()) {
            sinistres.forEach(this::printSinistre);
        } else {
            System.out.println("Aucun sinistre trouvé pour ce contrat.");
        }
    }

    private void printSinistre(Sinistre s) {
        System.out.println("ID: " + s.getId());
        System.out.println("Date début: " + s.getDateDebut());
        System.out.println("Type: " + s.getTypeSinistreEnum());
        System.out.println("---------------------------");
    }
}
