package jeu;

import java.util.*;
import jeu.combattants.*;
import jeu.gestions.*;
import jeu.inventaire.InventaireJoueur;
import jeu.inventaire.InventaireMarchand;
import jeu.mobs.*;


public class JeuAlternatif {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier", "Pretre", "Abomination"};
        System.out.println("Veuillez choisir vos combattants (Max 4)");
        for (int i = 0; i < combattants.length; i++) {
            System.out.println(i+". "+combattants[i]);
        }
        for(int i = 4; i > 0; i--) {
            nbCombattant = scanner.nextInt();
            System.out.println("Vous avez selectionné "+combattants[nbCombattant]+", il vous reste "+i+" choix");
            switch (nbCombattant) {
                case 0 -> equipe.getEquipe().add(new Paladin());
                case 1 -> equipe.getEquipe().add(new Berserker());
                case 2 -> equipe.getEquipe().add(new Mage());
                case 3 -> equipe.getEquipe().add(new Archer());
                case 4 -> equipe.getEquipe().add(new Voleur());
                case 5 -> equipe.getEquipe().add(new Guerrier());
                case 6 -> equipe.getEquipe().add(new Pretre());
                case 7 -> equipe.getEquipe().add(new Abomination());
                
            }
        }
    }

    public static void Mobs(Equipe groupe) {
        int nombre = (int)(6*Math.random());
        int type = (int)(3*Math.random());

        for(int i = 0; i < nombre; i++) {
            switch(type) {
                case 0 -> groupe.getEquipe().add(new Diablotin());
                case 1 -> groupe.getEquipe().add(new Cultist());
                case 2 -> groupe.getEquipe().add(new Demon());
            }
        }
    }

    public static void prochainEvent(Scanner scanner, Equipe equipe, InventaireJoueur inventaire) {
        
        int seed = (int)(3*Math.random());
        switch(seed) {
            case 0 -> {
                Equipe mobs = new Equipe();
                Mobs(mobs);
                Combat arene = new Combat(equipe, mobs, scanner);
                arene.lancerCombat();
            }
            case 1 -> repos(equipe);
            case 2 -> {
                InventaireMarchand inventaireMarchand = new InventaireMarchand();
                inventaireMarchand.shopping(scanner, inventaire, equipe);
            }
        }
    }

    public static void repos(Equipe equipe) {
        for(Combattant i : equipe.getEquipe()) {
            if(i.getPVMax() < i.getPV() - 50) {
                i.regenererPV(50);
            }else {
                i.regenererPV(i.getPVMax() - i.getPV());
            }
            System.out.println("Votre groupe a trouvé une zone de repos !");
            System.out.println("Toute votre equipe se regenere de 50 hp !");
        }
    }

    public static void boucleDeJeu(Scanner scanner, Equipe equipe, InventaireJoueur inventaire) {
        while (true) { 
            System.out.println("1. Prochain evenement");
            System.out.println("2. Inventaire");
            int choix = scanner.nextInt();
                switch(choix) {
                    case 1 -> prochainEvent(scanner, equipe, inventaire);
                    case 2 -> {
                        System.out.println(inventaire.toString());
                        System.out.print("Quel consommable voulez-vous utiliser ? ");
                        String choixNom = scanner.next();
                        switch(choixNom) {
                            case "Potion" -> {
                                for( jeu.items.Item i : new HashMap<>(inventaire.getInventaire()).keySet()) {
                                    if(i.toString().equals("Potion")) {
                                        inventaire.utiliserItem(i, equipe);
                                    }
                                }
                                
                            }
                            case "Biere" -> {
                                for( jeu.items.Item i : new HashMap<>(inventaire.getInventaire()).keySet()) {
                                    if(i.toString().equals("Biere")) {
                                        inventaire.utiliserItem(i, equipe);
                                    }
                                }
                                
                            }
                        }

                    }
                }
            System.out.println("");
        }
        
    }

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe = new Equipe();
        InventaireJoueur inventaire = new InventaireJoueur();
        inventaire.starterKit();

        choixCombattant(equipe, scanner);
        equipe.toString();
        boucleDeJeu(scanner, equipe, inventaire);

    }
}