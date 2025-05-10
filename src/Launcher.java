package src;
import java.util.Scanner;

import src.jeu.gestions.UtilitaireJeu;
import src.jeu.mode.*;

/**
 * Classe principale du jeu.
 * Permet de lancer le jeu et de choisir le mode de jeu.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 */
public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Jeu Classique");
            System.out.println("2. Jeu Alternatif");
            System.out.println("3. Wiki");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            int choix = UtilitaireJeu.saisieMenu(scanner, 1, 4);

            if (choix == 1) {
                Jeu.lancerJeu();
            } else if (choix == 2) {
                JeuAlternatif.lancerJeuAlternatif();
            } else if(choix == 3) {
                System.out.println("Wiki en construction...");
            }else {
                scanner.close();
                break; 
            }
        }  
    }
}
