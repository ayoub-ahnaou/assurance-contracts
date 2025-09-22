package views;

import java.util.Scanner;

public class ClientView {

    public static void afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=== MENU GESTION CLIENTS ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client par ID");
            System.out.println("3. Rechercher un client par nom de famille");
            System.out.println("4. Rechercher un client par ID");
            System.out.println("5. Afficher les clients d'un conseiller");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
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
}
