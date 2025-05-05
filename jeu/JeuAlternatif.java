package jeu;
import java.util.*;


import jeu.combattants.*;
import jeu.gestions.Combat;
import jeu.gestions.*;

public class JeuAlternatif {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier", "Pretre", "Abomination"};
        System.out.println("Veuillez choisir vos combattants (Max 4)");
        for (int i = 0; i < combattants.length; i++) {
            System.out.println(i+". "+combattants[i]);
        }
        for(int i = 0; i < 4; i++) {
            nbCombattant = scanner.nextInt();
            System.out.println("Vous avez selectionné "+combattants[nbCombattant]+"il vous reste "+i+"choix");
            switch (nbCombattant) {
                case 0: equipe.getEquipe().add(new Paladin()); break;
                case 1: equipe.getEquipe().add(new Berserker()); break;
                case 2: equipe.getEquipe().add(new Mage()); break;
                case 3: equipe.getEquipe().add(new Archer()); break;
                case 4: equipe.getEquipe().add(new Voleur()); break;
                case 5: equipe.getEquipe().add(new Guerrier());break;
                case 6: equipe.getEquipe().add(new Pretre());break;
                case 7: equipe.getEquipe().add(new Abomination());
                
            }
        }
    }

    public void Mobs(Equipe groupe) {
        int nombre = (int)(6*Math.random());
        int type = (int)(3*Math.random());

        for(int i = 0; i < nombre; i++) {
            switch(type) {
                case 0 : groupe.getEquipe().add(new Diablotin()); break;
                case 1 : groupe.getEquipe().add(new Cultist()); break;
                case 2 : groupe.getEquipe().add(new Demon()); break;
            }
        }
    }

    public void prochainEvent(Equipe equipe, Scanner scanner) {
        
        int seed = (int)(2*Math.random());
        switch(seed) {
            case 0 :
                Equipe mobs = new Equipe();
                Mobs(mobs);
                Combat arene = new Combat(equipe, mobs, scanner);
                arene.lancerCombat();
                break;
            case 1: 
                repos(equipe);
        }
    }

    public void repos(Equipe equipe) {
        for(Combattant i : equipe.getEquipe()) {
            i.regenererPV(50);
        }
    }

    public void boucleDeJeu(Scanner scanner, Equipe equipe, Inventaire inventaire) {
        while (true) { 
            
            System.out.println("1. Prochain event");
            System.out.println("2. Inventaire");
            System.out.println("3. Status de l'equipe");
            int choix = scanner.nextInt();
                switch(choix) {
                    case 1 : prochainEvent(equipe, scanner); break;
                    case 2 : inventaire.ouvrirInventaire(); break;
                    case 3 : equipe.toString();
                }
            System.out.println("");
        }
        
    }

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe = new Equipe();
        /* Equipe mobs = new Equipe(); */

        choixCombattant(equipe, scanner);

    }
}