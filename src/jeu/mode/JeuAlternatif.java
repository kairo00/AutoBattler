package src.jeu.mode;

import java.util.*;

import src.Launcher;
import src.entitees.*;
/* import src.entitees.boss.*; */

import src.inventaire.InventaireJoueur;

import src.jeu.gestions.*;

/**
 * Classe principale pour le mode de jeu alternatif.
 * Permet de choisir une équipe de combattants et de faire face a plusieurs évenement (repos, marchand, vague d'ennemis).
 * Le joueur peut choisir ses combattants, utiliser des objets et voir son équipe.
 */
public class JeuAlternatif {
     /**
     * Demande à l'utilisateur le nombre de chaque type de combattants qu'il veut dans sont équipe.
     * @param equipe qui doit être constituée
     * @param scanner permettant la saisie utilisateur
     */
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
    
    /**
     * Boucle de jeu, le joueur choisit la prochaine actions qu'il va effectué entre chaque manches
     * @param scanner permettant la saisie utilisateur
     * @param equipe équipe du joueur
     * @param inventaire inventaire du joueur
     */
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
                    //Option 1 : prochain event
                    case 1 -> {
                        event.prochainEvent();
                        if(!equipe.aDesVivants()) break;
                    //Option 2 : Ouverture de l'inventaire
                    }
                    case 2 -> {
                        System.out.println(inventaire.toString());
                        //Si le joueur veut consommer un item il doit taper son nom 
                        System.out.print("[ENTRER] pour quitter\nQuel consommable voulez-vous utiliser ?");
                        String choixNom = scanner.nextLine();
                        if(choixNom.isEmpty()) break;
                        //Utilise l'item choisi si disponible
                        boolean utiliser = inventaire.utiliserItemNom(choixNom, equipe);
                        if(!utiliser) System.out.println("Cet item n'est pas dans votre inventaire.");
                    }
                    //Option 3 : Affiche l'équipe
                    case 3 -> System.out.println(equipe.toString());
                    //Option 4 : Quitte le jeu
                    case 4 -> Launcher.main(null);
                }
            System.out.println("");
        }
        
    }
    
    /**
     * Méthode statique qui lance le jeu alternatif.
     */
    public static void lancerJeuAlternatif () {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe = new Equipe();
        InventaireJoueur inventaire = new InventaireJoueur();
        inventaire.starterKit();

        choixCombattant(equipe, scanner);
        boucleDeJeu(scanner, equipe, inventaire);

    }
}