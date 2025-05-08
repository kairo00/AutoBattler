package jeu;
import java.util.Scanner;
import jeu.mode.*;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Menu Principal ===");
        System.out.println("1. Jeu Classique");
        System.out.println("2. Jeu Alternatif");
        System.out.println("3. Wiki");
        System.out.println("4. Quitter");
        System.out.print("Choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // pour vider la ligne
        switch (choix) {
            case 1 -> Jeu.lancerJeu(); // appel du jeu classique
            case 2 -> JeuAlternatif.lancerJeuAlternatif();// appel du jeu alternatif
            case 3 -> {
                jeu.Wiki wiki = new Wiki();
                wiki.activeWiki();
            }
            default -> {
                System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}
