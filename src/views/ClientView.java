package views;

import controllers.ClientController;
import models.Client;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class ClientView {
    ClientController controller = new ClientController();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        int choix;

        do {
            System.out.println("\n=== MENU GESTION CLIENTS ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client par ID");
            System.out.println("3. Rechercher un client par nom de famille");
            System.out.println("4. Rechercher un client par ID");
            System.out.println("5. Afficher les clients d'un conseiller");
            System.out.println("6. Trie les clients par nom de famille");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    this.createClient();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }

            if (choix != 0) {
                System.out.print("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }

        } while (choix != 0);
    }

    public void createClient() {
        System.out.print("Enter nom: ");
        String nom = scanner.nextLine();

        System.out.print("Enter prenom: ");
        String prenom = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter conseiller id: ");
        String conseillerId = scanner.nextLine();

        controller.createClient(
                UUID.randomUUID().toString(),
                nom,
                prenom,
                email,
                conseillerId
        );
    }

    /*
    void deleteClient() {
        System.out.print("Entrez l'ID du client à supprimer: ");
        String clientId = scanner.nextLine();

        boolean success = controller.deleteClient(clientId);
        if (success) {
            System.out.println("Client supprimé avec succès !");
        } else {
            System.out.println("Erreur: Client non trouvé !");
        }
    }

    void searchClientByLastName() {
        System.out.print("Entrez le nom de famille à rechercher: ");
        String lastName = scanner.nextLine();

        List<Client> clients = controller.searchClientsByLastName(lastName);

        if (clients.isEmpty()) {
            System.out.println("Aucun client trouvé avec ce nom de famille.");
        } else {
            System.out.println("\n=== CLIENTS TROUVÉS ===");
            clients.forEach(client ->
                    System.out.printf("ID: %s | Nom: %s %s | Email: %s%n",
                            client.getId(), client.getPrenom(), client.getNome(), client.getEmail()));
        }
    }

    void searchClientById() {
        System.out.print("Entrez l'ID du client: ");
        String clientId = scanner.nextLine();

        Optional<Client> client = controller.searchClientById(clientId);

        if (client.isPresent()) {
            Client c = client.get();
            System.out.println("\n=== CLIENT TROUVÉ ===");
            System.out.printf("ID: %s%n", c.getId());
            System.out.printf("Nom: %s %s%n", c.getPrenom(), c.getNome());
            System.out.printf("Email: %s%n", c.getEmail());
            System.out.printf("Conseiller ID: %s%n", c.getConseiller_id());
        } else {
            System.out.println("Client non trouvé !");
        }
    }

    void displayClientsByAdvisor() {
        System.out.print("Entrez l'ID du conseiller: ");
        String advisorId = scanner.nextLine();

        List<Client> clients = controller.getClientsByAdvisorId(advisorId); // fix return function in controller

        if (clients.isEmpty()) {
            System.out.println("Aucun client trouvé pour ce conseiller.");
        } else {
            System.out.printf("\n=== CLIENTS DU CONSEILLER %s ===%n", advisorId);
            clients.forEach(client ->
                    System.out.printf("ID: %s | Nom: %s %s | Email: %s%n",
                            client.getId(), client.getPrenom(), client.getNome(), client.getEmail()));
        }
    }

    void sortClientsByLastName() {
        List<Client> clients = controller.getAllClientsSortedByLastName();

        if (clients.isEmpty()) {
            System.out.println("Aucun client dans la base de données.");
        } else {
            System.out.println("\n=== CLIENTS TRIÉS PAR NOM ===");
            clients.forEach(client ->
                    System.out.printf("Nom: %s | Prénom: %s | Email: %s | ID: %s%n",
                            client.getNome(), client.getPrenom(), client.getEmail(), client.getId()));
        }
    }
     */
}
