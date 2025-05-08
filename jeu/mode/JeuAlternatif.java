package jeu.mode;


import java.util.*;
import jeu.boss.Monika;
import jeu.boss.Nashor;
import jeu.boss.Ragnaros;
import jeu.boss.Sanguinius;
import jeu.combattants.*;
import jeu.gestions.*;
import jeu.inventaire.InventaireJoueur;
import jeu.inventaire.InventaireMarchand;
import jeu.items.*;
import jeu.miniboss.Graymarrow;
import jeu.miniboss.Herald;
import jeu.miniboss.KingSlime;
import jeu.mobs.*;


public class JeuAlternatif {

    static int compteur = 1;

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier", "Pretre", "Abomination"};
        System.out.println("Veuillez choisir vos combattants (Max 4)");
        for (int i = 0; i < combattants.length; i++) {
            System.out.println(i+1+". "+combattants[i]);
        }
        for(int i = 4; i > 0; i--) {
            nbCombattant = scanner.nextInt();
            System.out.println("Vous avez selectionné "+combattants[nbCombattant-1]+", il vous reste "+(i-1)+" choix");
            switch (nbCombattant) {
                case 1 -> equipe.getEquipe().add(new Paladin());
                case 2 -> equipe.getEquipe().add(new Berserker());
                case 3 -> equipe.getEquipe().add(new Mage());
                case 4 -> equipe.getEquipe().add(new Archer());
                case 5 -> equipe.getEquipe().add(new Voleur());
                case 6 -> equipe.getEquipe().add(new Guerrier());
                case 7 -> equipe.getEquipe().add(new Pretre());
                case 8 -> equipe.getEquipe().add(new Abomination());
                
            }
        }
    }

    public static void Mobs(Equipe groupe) {
        int nombre = (int)(3*Math.random()+3);

        for(int i = 0; i < nombre; i++) {
            int type = (int)(3*Math.random());
            switch(type) {
                case 0 -> groupe.getEquipe().add(new Diablotin());
                case 1 -> groupe.getEquipe().add(new Cultist());
                case 2 -> groupe.getEquipe().add(new Demon());
            }
        }
    }

    public static void miniBoss(Equipe boss) {
        int type = (int)(3*Math.random());
        switch(type) {
            case 0 -> { 
                boss.getEquipe().add(new KingSlime());
                System.out.println("* Une pluie de slime s'abat ! *");
            }
            case 1 -> {
                boss.getEquipe().add(new Graymarrow());
                System.out.println("Graymarrow : Vous ne vous en sortirez pas vivant !");
            }
            case 2 -> {
                boss.getEquipe().add(new Herald());
                System.out.println("* Une brêche dimensionelle s'ouvre devant vous. *");
            }
        }
    }

    public static void boss(Equipe boss) {
        int type = (int)(3*Math.random());
        switch(type) {
            case 0 -> { 
                boss.getEquipe().add(new Monika());
                System.out.println("Monika : ... Tu tentes de passer ?");
            }
            case 1 -> {
                boss.getEquipe().add(new Nashor());
                System.out.println("* Une enorme faille dimensionelle s'ouvre devant vous *");
            }
            case 2 -> {
                boss.getEquipe().add(new Ragnaros());
                System.out.println("Ragnaros : PAR LE FEU SOYEZ PURIFIÉ");
            }

            case 3 -> {
                boss.getEquipe().add(new Sanguinius());
                System.out.println("Sanguinius : Je ne veux pas être ici");
            }
        }
    }
    public static void prochainEvent(Scanner scanner, Equipe equipe, InventaireJoueur inventaire) {
        int seed = (int)(10*Math.random());
        if(compteur%10 == 0) {
            Equipe boss = new Equipe();
            boss(boss);
            Combat arene = new Combat(equipe, boss, scanner);
            arene.lancerCombat();
        }else{
            if(compteur%5 == 0) {
                Equipe boss = new Equipe();
                miniBoss(boss);
                Combat arene = new Combat(equipe, boss, scanner);
                arene.lancerCombat();
            }else{
                if(seed < 7) {
                    Equipe mobs = new Equipe();
                    Mobs(mobs);
                    Combat arene = new Combat(equipe, mobs, scanner);
                    arene.lancerCombat();
                    if(!equipe.aDesVivants()) {
                        System.out.println("Game Over !");
                        System.exit(0);
                    }else{
                        int or = (int)(80*Math.random());
                        inventaire.ajoutOr(or);
                        System.out.println("Vous avez gagnez "+or+" d'or");
                        tableDeButin(inventaire);
                    }
                }else{
                    if(seed < 9) {
                        repos(scanner, equipe);
                    } else {
                        InventaireMarchand inventaireMarchand = new InventaireMarchand();
                        inventaireMarchand.shopping(scanner, inventaire, equipe);
                    }
                }
            }
            compteur++;
        }
    }

    public static void repos(Scanner scanner, Equipe equipe) {
        System.out.println("Votre groupe a trouvé une zone de repos !");
        System.out.println("1. Se reposer");
        System.out.println("2. Se raconter des histoires");
        int choix = scanner.nextInt();
        switch(choix) {
            case 1 -> {
                for(Combattant i : equipe.getEquipe()) {
                    if(i.getPvMax() < i.getPV() - 50) {
                        i.regenererPV(50);
                    }else {
                        i.regenererPV(i.getPvMax() - i.getPV());
                    }
                }
                System.out.println("Toute votre equipe se regenere de 50 hp !");
            }
            case 2 -> {
                for(Combattant i : equipe.getEquipe()) {
                    if(i.getCourageMax() < i.getCourage() - 50) {
                        i.regenererCourage(50);
                    }else {
                        i.regenererPV(i.getCourageMax() - i.getCourage());
                    }
                }
                System.out.println("Toute votre equipe se regenere 50 de courage !");
            }
        }
        
    }

    public static void tableDeButin(InventaireJoueur inventaire) {
        int porteurDeCendre = (int)(100*Math.random());
        if(porteurDeCendre < 5) {
            inventaire.getInventaire().put(new PorteurdeCendre(), 1);
        }
    }

    public static void boucleDeJeu(Scanner scanner, Equipe equipe, InventaireJoueur inventaire) {
        while (true) { 
            System.out.println("+=========================+");
            System.out.println("|         Round "+compteur+"         |"); 
            System.out.println("+-------------------------+");
            System.out.println("|  1. Prochain evenement  |");
            System.out.println("|  2. Inventaire          |");
            System.out.println("+-------------------------+");
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

    public static void lancerJeuAlternatif () {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe = new Equipe();
        InventaireJoueur inventaire = new InventaireJoueur();
        inventaire.starterKit();

        choixCombattant(equipe, scanner);
        equipe.toString();
        boucleDeJeu(scanner, equipe, inventaire);

    }
}