package src.jeu.mode;

import java.util.*;

import src.Launcher;
import src.entitees.*;
/* import src.entitees.boss.*; */

import src.inventaire.InventaireJoueur;

import src.jeu.gestions.*;


public class JeuAlternatif {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        System.out.println("Veuillez choisir vos combattants (Max 4)");
        GenCombattant.afficherMenuAlt();
        for(int i = 4; i > 0; i--) {
            nbCombattant = scanner.nextInt();
            while(nbCombattant < 1 || nbCombattant > GenCombattant.getNbCombattants()) {
                System.out.println("Erreur : Aucun combattant ne correspond !");
                System.out.print("Nouveau choix ~ ");
                nbCombattant= scanner.nextInt();
            }
            Combattant c = GenCombattant.generer(nbCombattant);
            equipe.ajouterCombattant(c);
            System.out.println("Vous avez selectionné "+c.toString()+", il vous reste "+(i-1)+" choix");
        }
    }

    public static void boucleDeJeu(Scanner scanner, Equipe equipe, InventaireJoueur inventaire) {
        GestionEvenement event = new GestionEvenement(scanner, equipe, inventaire);
        while (true) { 
            System.out.println("+=========================+");
            System.out.println("|         Round "+event.getCompteur()+"         |"); 
            System.out.println("+-------------------------+");
            System.out.println("|  1. Prochain evenement  |");
            System.out.println("|  2. Inventaire          |");
            System.out.println("|  3. Voir équipe         |");
            System.out.println("|  4. Quitter             |");
            System.out.println("+-------------------------+");
            int choix = UtilitaireJeu.saisieMenu(scanner, 1, 4);
                switch(choix) {
                    case 1 -> {
                        event.prochainEvent();
                        if(!equipe.aDesVivants()) break;
                    }
                    case 2 -> {
                        System.out.println(inventaire.toString());
                        System.out.print("[ENTRER] pour quitter\nQuel consommable voulez-vous utiliser ?");
                        scanner.nextLine();
                        String choixNom = scanner.nextLine();
                        if(choixNom.isEmpty()) break;
                        boolean utiliser = inventaire.utiliserItemNom(choixNom, equipe);
                        if(!utiliser) System.out.println("Cet item n'est pas dans votre inventaire.");
                    }
                    case 3 -> System.out.println(equipe.toString());
                    case 4 -> Launcher.main(null);
                }
            System.out.println("");
        }
        
    }

    public static void lancerJeuAlternatif () {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe = new Equipe();
        InventaireJoueur inventaire = new InventaireJoueur();
        inventaire.starterKit();

        choixCombattant(equipe, scanner);
        boucleDeJeu(scanner, equipe, inventaire);

    }
}