package src.jeu.mode;
import java.util.*;

import src.Launcher;
import src.entitees.*;
import src.jeu.gestions.Combat;
import src.jeu.gestions.Equipe;
import src.jeu.gestions.GenCombattant;
import src.jeu.gestions.UtilitaireJeu;

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
        List<String> combattants = GenCombattant.genNomCombattants();

        do {
            equipe.getEquipe().clear();
            System.out.println("\n\nChoix pour l'équipe "+equipe.getID());
            
            for (int i = 0; i < combattants.size(); i++) {
                System.out.println("Nombre de " + combattants.get(i) + " :");
                nbCombattant = scanner.nextInt();
                scanner.nextLine();

                for (int j = 0; j < nbCombattant; j++) {
                    Combattant c = GenCombattant.genererParNom(combattants.get(i));
                    equipe.ajouterCombattant(c);
                }
            }
            
            if(equipe.getEquipe().isEmpty()) {
                System.out.println("Impossible de lancer le combat.\n\t Touche [Entrer] : Refaire son équipe.\n\t Autres touches : quitter la partie.\nChoix :");
                choix = scanner.nextLine();
            } else {
                choix = "Statut: quitter";
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
        List<String> combattants = GenCombattant.genNomCombattants();
        Collections.shuffle(combattants);

        /* Tableau contenant les combattants tirés au hasard */
        String [] combattantHasard = {combattants.get(0), combattants.get(1), combattants.get(2)};

        /* Affichage des 3 combattants. */
        System.out.println("\nChoix pour l'équipe "+equipe.getID());
        System.out.println("Choisi parmis les combattants suivant:");
        for(int i = 0; i<3;i++) {
            System.out.println((i+1)+". "+combattantHasard[i]);
        }

        /* Saisie du choix de l'utilisateur */
        int choix = UtilitaireJeu.saisieMenu(scanner, 1, 3);

        /* Ajoute le bon membre de l'équipe selon le choix d'utilisateur */
        equipe.ajouterCombattant(GenCombattant.genererParNom(combattantHasard[choix-1]));
    }

    /**
     * Attribut automatiquement et aléatoirement un combattant dans l'équipe de l'ordinateur.
     * @param equipe qui doti etre constituée (ordinateur)
     */
    public static void choixCombattantOrdi(Equipe equipe) {

        List<String> combattants = GenCombattant.genNomCombattants();
        Collections.shuffle(combattants);

        /* Tableau contenant les combattants tirés au hasard */
        String [] combattantHasard = {combattants.get(0), combattants.get(1), combattants.get(2)};
        int r = (int) (Math.random()*combattantHasard.length);
        /* Affichage des 3 combattants. */
        System.out.println("\n[🤖] Le robot à choisi parmis les combattants suivant:");
        for(int i = 0; i<3;i++) {
            System.out.println((i+1)+". "+combattantHasard[i]);
        }
        Combattant c = GenCombattant.genererParNom(combattantHasard[r]);
        equipe.ajouterCombattant(c);
    }

    /**
     * Demande a l'utilisateur s'il veut quitter ou continuer la partie en cours.
     * @param scanner permettant la saisie utilisateur
     * @return un booléen, true si l'utilisateur entre n, false s'il entre y
     */
    public static boolean demanderQuitter(Scanner scanner) {
        String reponse = "";
        do {
            System.out.println("Voulez-vous quitter la partie ? [y/n]");
            reponse = scanner.nextLine().trim();
        } while (reponse.isEmpty() || (!reponse.equalsIgnoreCase("y") && !reponse.equalsIgnoreCase("n")));
        return reponse.equalsIgnoreCase("n");
    }

    public static void lancerJeu() {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        Combat arene = new Combat(equipe1, equipe2);

        final int TEST=1, PVP=2, PVE=3, QUITTER=4, TEAM_SIZE=5;
        boolean partieLance;
        int choix = 0;
        while(true) {

            //Affichage du menu
            System.out.println("1. Mode Test 🧪");
            System.out.println("2. Mode PVP");
            System.out.println("3. Mode PVE 🤖");
            System.out.println("4. Quitter 🚪");
            
            //Saisie utilisateur
            choix = UtilitaireJeu.saisieMenu(scanner, 1, 4);

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
                    if(i%2==0) choixCombattantOrdi(equipe2);
                    else choixCombattantPvp(equipe1, scanner);
                }
                partieLance=true;
                while(partieLance) {
                    arene.lancerCombat();
                    partieLance=false;
                }
            
            /* Quitter le jeu */
            } else if (choix == QUITTER) {
                Launcher.main(null);
            }
        }
    }
}