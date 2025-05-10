package src.jeu.gestions;

import java.util.Scanner;

public class UtilitaireJeu {
        /**
     * Permet de gérer le choix des utilisateurs dans le menu ou en partie.
     * @param scanner permettant la saisie de l'utilisateur
     * @param min entier minimum que l'utilisateur doit saisir pour que le choix soit correcte
     * @param max entier maximum que l'utilisateur doit saisir pour que le choix soit correcte
     * @return l'entier correspondant au choix de l'utilisateur
     */
    public static int saisieMenu(Scanner scanner, int min, int max) {
        int choix=-1;
        do {
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le '\n' restant après nextInt()
            } else {
                scanner.nextLine(); // Consommer l'entrée invalide si c'est un texte
                System.out.println("Veuillez entrer un nombre valide.");
                continue;
            }
        }while(choix < min || choix > max);
        return choix;
    }


}
