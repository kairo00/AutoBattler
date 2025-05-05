package jeu;
import java.util.*;

import jeu.combattants.*;
import jeu.gestions.Combat;
import jeu.gestions.Equipe;

/**
 * Cette classe est le fichier principal.
 * La classe Jeu gère le fonctionnement du jeu: les menus, les différents mode de jeu, ainsi que le choix des combattants.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 */
public class Jeu {

    /**
     * Demande à l'utilisateur le nombre de chaque type de combattants qu'il veut dans sont équipe.
     * @param equipe qui doit être constituée
     * @param scanner permettant la saisie utilisateur
     */
    public static void choixCombattantTest(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String choix;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"};

        do {
        equipe.getEquipe().clear();
        System.out.println("\n\nChoix pour l'équipe "+equipe.getID());
        for (int i = 0; i < combattants.length; i++) {
            System.out.println("Nombre de " + combattants[i] + " :");
            nbCombattant = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < nbCombattant; j++) {
                switch (i) {
                    case 0: equipe.getEquipe().add(new Paladin()); break;
                    case 1: equipe.getEquipe().add(new Berserker()); break;
                    case 2: equipe.getEquipe().add(new Mage()); break;
                    case 3: equipe.getEquipe().add(new Archer()); break;
                    case 4: equipe.getEquipe().add(new Voleur()); break;
                    case 5: equipe.getEquipe().add(new Guerrier());
                }
            }
        }
        if(equipe.getEquipe().isEmpty()) {
             System.out.println("Impossible de lancer le combat.\n\t Touche [Entrer] : Refaire son équipe.\n\t Autres touches : quitter la partie.\nChoix :");
            choix = scanner.nextLine();
        } else {
            choix = "quitter boucle";
        }
        }while(choix.isEmpty());
    }   

    /**
     * Propose une liste de trois combattants à l'utilisateur, il ne peut en choisir qu'un parmis les 3 dans son équipe.
     * @param equipe qui doit être constituée
     * @param scanner permettant la saisie utilisateur
     */
    public static void choixCombattantPvp(Equipe equipe, Scanner scanner) {
        /*Liste mélangée contenant tout les combattants */
        ArrayList<String> combattants = new ArrayList<>(Arrays.asList("Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"));
        Collections.shuffle(combattants);

        /* Tableau contenant les combattants tirés au hasard */
        String [] combattantHasard = {combattants.get(0), combattants.get(1), combattants.get(2)};

        /* Affichage des 3 combattants. */
        System.out.println("\n\nChoix pour l'équipe "+equipe.getID());
        System.out.println("Choisi parmis les combattants suivant:");
        for(int i = 0; i<3;i++) {
            System.out.println((i+1)+". "+combattantHasard[i]);
        }

        /* Saisie du choix de l'utilisateur */
        int choix = saisieMenu(scanner, 1, 3);
        scanner.nextLine();

        /* Ajoute le bon membre de l'équipe selon le choix d'utilisateur */
        switch (combattantHasard[choix-1]) {
            case "Paladin": equipe.getEquipe().add(new Paladin()); break;
            case "Berserker": equipe.getEquipe().add(new Berserker()); break;
            case "Mage": equipe.getEquipe().add(new Mage()); break;
            case "Archer": equipe.getEquipe().add(new Archer()); break;
            case "Voleur": equipe.getEquipe().add(new Voleur()); break;
            case "Guerrier": equipe.getEquipe().add(new Guerrier());
        }
    }

    /**
     * Attribut automatiquement et aléatoirement un combattant dans l'équipe de l'ordinateur.
     * @param equipe qui doti etre constituée (ordinateur)
     */
    public static void choixCombattantOrdi(Equipe equipe) {
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"};
        int r = (int) (Math.random()*combattants.length);
        switch (combattants[r]) {
            case "Paladin": equipe.getEquipe().add(new Paladin()); break;
            case "Berserker": equipe.getEquipe().add(new Berserker()); break;
            case "Mage": equipe.getEquipe().add(new Mage()); break;
            case "Archer": equipe.getEquipe().add(new Archer()); break;
            case "Voleur": equipe.getEquipe().add(new Voleur()); break;
            case "Guerrier": equipe.getEquipe().add(new Guerrier());
        }
        System.out.println("[🤖] À choisi "+combattants[r]);
    }

    /* optionnelle (a voir) */
    public static void afficherMenu() {
        return;
    }
    /**
     * Permet de gérer le choix des utilisateurs dans le menu ou en partie.
     * @param scanner permettant la saisie de l'utilisateur
     * @param min entier minimum que l'utilisateur doit saisir pour que le choix soit correcte
     * @param max entier maximum que l'utilisateur doit saisir pour que le choix soit correcte
     * @return l'entier correspondant au choix de l'utilisateur
     */
    public static int saisieMenu(Scanner scanner, int min, int max) {
        int choix;
        do {
            System.out.println("Choix ?");
            choix = scanner.nextInt();
        }while(choix < min || choix > max);
        return choix;
    }
    /**
     * Demande a l'utilisateur s'il veut quitter ou continuer la partie en cours.
     * @param scanner permettant la saisie utilisateur
     * @return un booléen, true si l'utilisateur entre n, false s'il entre y
     */
    public static boolean demanderQuitter(Scanner scanner) {
        char choix;
        do {
            System.out.println("Voulez-vous quitter la partie ? [y/n]");
            choix = scanner.nextLine().charAt(0);
        }while (choix != 'y' && choix != 'n' && choix != 'Y' && choix != 'N');
        return (choix == 'n' || choix == 'N');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        Combat arene = new Combat(equipe1, equipe2, scanner);

        final int TEST=1, PVP=2, PVE=3, QUITTER=4, TEAM_SIZE=5;
        boolean partieLance;
        int choix = 0;
        while(true) {

            //Affichage du menu
            System.out.println("1. Mode Test 🧪");
            System.out.println("2. Mode PVP");
            System.out.println("3. Mode PVE 🤖 (Un peu claqué)");
            System.out.println("4. Quitter 🚪");
            
            //Saisie utilisateur
            choix = saisieMenu(scanner, 1, 4);

            /* Mode test */
            if (choix == TEST) {
                partieLance=true;
                choixCombattantTest(equipe1, scanner);
                if(equipe1.getEquipe().isEmpty()) continue;
                choixCombattantTest(equipe2, scanner);
                if(equipe2.getEquipe().isEmpty()) continue;
                arene.lancerCombat();
            
            /* Mode PVP */
            } else if(choix == PVP) {
                equipe1.getEquipe().clear();
                equipe2.getEquipe().clear();
                for(int i = 0;i<(TEAM_SIZE*2);i++) {
                    if(i%2==0) choixCombattantPvp(equipe1, scanner);
                    else choixCombattantPvp(equipe2, scanner);
                }
                partieLance=true;
                while(partieLance) {
                    arene.lancerCombat();
                    partieLance=false;
                }
            
            /* Mode PVE */
            } else if(choix == PVE) {
                equipe1.getEquipe().clear();
                equipe2.getEquipe().clear();
                for(int i = 0;i<(TEAM_SIZE*2);i++) {
                    if(i%2==0) choixCombattantPvp(equipe1, scanner);
                    else choixCombattantOrdi(equipe2);
                }
                partieLance=true;
                while(partieLance) {
                    arene.lancerCombat();
                    partieLance=false;
                }
            
            /* Quitter le jeu */
            } else if (choix == QUITTER) break;
        }
        scanner.close();
    }
}
