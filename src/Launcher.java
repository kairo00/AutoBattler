package src;
import java.util.Scanner;

import src.jeu.mode.*;

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

        if (choix == 1) {
            Jeu.lancerJeu(); // appel du jeu classique
        } else if (choix == 2) {
            JeuAlternatif.lancerJeuAlternatif();// appel du jeu alternatif
        } else {
            System.out.println("Choix invalide.");
        }
        scanner.close();
    }
}
