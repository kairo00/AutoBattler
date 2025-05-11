package src.jeu.gestions;

import java.util.Scanner;

/**
 * Classe UtilitaireJeu
 * Cette classe contient des méthodes utilitaires pour le jeu.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public class UtilitaireJeu {

    public static final Scanner scanner = new Scanner(System.in);
        /**
     * Permet de gérer le choix des utilisateurs dans le menu ou en partie.
     * @param min entier minimum que l'utilisateur doit saisir pour que le choix soit correcte
     * @param max entier maximum que l'utilisateur doit saisir pour que le choix soit correcte
     * @return l'entier correspondant au choix de l'utilisateur
     */
    public static int saisieMenu(int min, int max) {
        int choix=-1;
        do {
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                scanner.nextLine(); 
                System.out.println("Veuillez entrer un nombre valide.");
                continue;
            }
        }while(choix < min || choix > max);
        return choix;
    }


}
