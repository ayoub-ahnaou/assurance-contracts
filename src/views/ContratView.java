package views;

import controllers.ContratController;
import enums.TypeContrat;
import models.Contrat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ContratView {
    private ContratController controller = new ContratController();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Gestion des Contrats =====");
            System.out.println("1. Ajouter un contrat");
            System.out.println("2. Afficher un contrat par ID");
            System.out.println("3. Afficher tous les contrats");
            System.out.println("4. Supprimer un contrat");
            System.out.println("5. Afficher les contrats d'un client");
            System.out.println("0. Retour");
            System.out.print("Choisissez une option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // flush newline

            switch (choice) {
                case 1:
                    addContrat();
                    break;
                case 2:
                    viewContratById();
                    break;
                case 3:
                    viewAllContrats();
                    break;
                case 4:
                    deleteContrat();
                    break;
                case 5:
                    viewContratsByClient();
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

    private void addContrat() {
        String id = UUID.randomUUID().toString();

        System.out.print("Date de début (yyyy-MM-dd): ");
        LocalDate dateDebut = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Date de fin (yyyy-MM-dd): ");
        LocalDate dateFin = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Montant: ");
        double montant = Double.parseDouble(scanner.nextLine());

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Type de contrat (AUTOMOBILE, IMMOBILIER, MALADIE): ");
        TypeContrat type = TypeContrat.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Client ID: ");
        String clientId = scanner.nextLine();

        controller.addContrat(id, dateDebut, dateFin, montant, description, type, clientId);
    }

    private void viewContratById() {
        System.out.print("ID du contrat: ");
        String id = scanner.nextLine();

        Contrat c = controller.getContratById(id);
        if (c != null) {
            printContrat(c);
        }
    }

    private void viewAllContrats() {
        List<Contrat> contrats = controller.getAllContrats();
        if (contrats != null && !contrats.isEmpty()) {
            contrats.forEach(this::printContrat);
        } else {
            System.out.println("Aucun contrat trouvé.");
        }
    }

    private void deleteContrat() {
        System.out.print("ID du contrat à supprimer: ");
        String id = scanner.nextLine();

        controller.deleteContrat(id);
    }

    private void viewContratsByClient() {
        System.out.print("Client ID: ");
        String clientId = scanner.nextLine();

        List<Contrat> contrats = controller.getContratsByClient(clientId);
        if (contrats != null && !contrats.isEmpty()) {
            contrats.forEach(this::printContrat);
        } else {
            System.out.println("Aucun contrat trouvé pour ce client.");
        }
    }

    private void printContrat(Contrat c) {
        System.out.println("ID: " + c.getId());
        System.out.println("Date début: " + c.getDateDebut());
        System.out.println("Date fin: " + c.getDateFin());
        System.out.println("Montant: " + c.getMontant());
        System.out.println("Description: " + c.getDescription());
        System.out.println("Type: " + c.getTypeContratEnum());
        System.out.println("---------------------------");
    }
}
