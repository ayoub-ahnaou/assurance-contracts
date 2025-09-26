package views;

import controllers.ClientController;
import models.Client;
import models.Contrat;
import models.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientView {
    ClientController controller = new ClientController();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Client Management =====");
            System.out.println("1. Ajouter Client");
            System.out.println("2. Afficher client par ID");
            System.out.println("3. Afficher tous les Clients");
            System.out.println("4. Supprimer Client");
            System.out.println("5. Afficher clients par Conseiller");
            System.out.println("6. Trie clients par ordre alphabitique");
            System.out.println("0. Retour");
            System.out.print("Choisissez une option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: addClient(); break;
                case 2: viewClientById(); break;
                case 3: viewAllClients(); break;
                case 4: deleteClient(); break;
                case 5: viewClientsByConseiller(); break;
                case 6: sortClients(); break;
                case 0:
                    System.out.println("Bye"); return;
                default: System.out.println("Invalid choice, try again."); break;
            }
        }
    }

    private void addClient() {
        String id = UUID.randomUUID().toString();
        System.out.print("Enter Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Enter Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter conseiller Id: ");
        String conseillerId = scanner.nextLine();

        Client client = new Client(id, nom, prenom, email, conseillerId);
        controller.addClient(client);
    }

    private void viewClientById() {
        System.out.print("Enter Client ID: ");
        String id = scanner.nextLine();
        Client client = controller.getClientById(id);
        printClient(client);
    }

    private void viewAllClients() {
        List<Client> clients = controller.getAllClients();
        if (clients != null && !clients.isEmpty()) {
            clients.forEach(this::printClient);
        } else {
            System.out.println("No clients found.");
        }
    }

    private void deleteClient() {
        System.out.print("Enter Client ID to delete: ");
        String id = scanner.nextLine();
        controller.deleteClient(id);
    }

    private void viewClientsByConseiller() {
        System.out.print("Enter Conseiller ID: ");
        String conseillerId = scanner.nextLine();
        List<Client> clients = controller.getClientsByConseiller(conseillerId);
        if (clients != null && !clients.isEmpty()) {
            clients.forEach(this::printClient);
        } else {
            System.out.println("No clients found for this conseiller.");
        }
    }

    private void sortClients() {
        List<Client> clients = controller.getAllClients();
        clients.stream()
                .sorted(Comparator.comparing(Client::getNom))
                .forEach(this::printClient);
    }

    private void printClient(Client c) {
        System.out.println("ID: " + c.getId());
        System.out.println("Nom: " + c.getNom());
        System.out.println("Prenom: " + c.getPrenom());
        System.out.println("Email: " + c.getEmail());
        System.out.println("---------------------------");
    }
}
