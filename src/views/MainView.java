package views;

import java.util.Scanner;

public class MainView {
    ClientView clientView = new ClientView();
    ConseillerView conseillerView = new ConseillerView();
    ContratView contratView = new ContratView();
    SinistreView sinistreView = new SinistreView();

    public void MenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=== ASSURANCE APPLICATION MENU ===");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Conseillers");
            System.out.println("3. Manage Contrats");
            System.out.println("4. Manage Sinistres");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    clientView.showMenu();
                    break;
                case 2:
                    conseillerView.showMenu();
                    break;
                case 3:
                    contratView.showMenu();
                    break;
                case 4:
                    sinistreView.showMenu();
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
