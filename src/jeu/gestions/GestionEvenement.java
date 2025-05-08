package src.jeu.gestions;
import java.util.*;

import src.Launcher;
import src.entitees.Combattant;
import src.entitees.miniboss.Graymarrow;
import src.entitees.miniboss.Herald;
import src.entitees.miniboss.KingSlime;
import src.entitees.mobs.Cultist;
import src.entitees.mobs.Demon;
import src.entitees.mobs.Diablotin;
import src.inventaire.InventaireJoueur;
import src.inventaire.InventaireMarchand;
import src.items.PorteurdeCendre;

public class GestionEvenement {
    private Scanner scanner;
    private Equipe equipe;
    private InventaireJoueur inventaire;

    private int compteur = 1;

    public GestionEvenement(Scanner scanner, Equipe equipe, InventaireJoueur inventaire) {
        this.scanner = scanner;
        this.equipe = equipe;
        this.inventaire = inventaire;
    }

    public void genererMobs(Equipe groupe) {
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

    public void genererBoss(Equipe boss) {
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

    public void prochainEvent() {
        int seed = (int)(10*Math.random());
        
        if(compteur == 5 && equipe.aDesVivants()) {
            Equipe boss = new Equipe();
            genererBoss(boss);
            Combat arene = new Combat(equipe, boss, scanner);
            arene.lancerCombat();
            if(!equipe.aDesVivants()) {
                System.out.println("Game Over !");
                System.out.println("[ENTRER] Revenir au menu principal\nAppuyer sur n'importe quelles touches pour quitter.");
                String choix = scanner.nextLine();
                if(choix.isEmpty()) Launcher.main(null);
                System.exit(0);
            }
        }else if(seed < 7 && equipe.aDesVivants()){
            Equipe mobs = new Equipe();
            genererMobs(mobs);
            Combat arene = new Combat(equipe, mobs, scanner);
            arene.lancerCombat();
                if(!equipe.aDesVivants()) {
                    System.out.println("Game Over !");
                    System.out.println("[ENTRER] Revenir au menu principal\nAppuyer sur n'importe quelles touches pour quitter.");
                    String choix = scanner.nextLine();
                    if(choix.isEmpty()) Launcher.main(null);
                    System.exit(0);
                }else{
                    int r = (int)(80*Math.random());
                    inventaire.ajoutOr(r);
                    System.out.println("Vous avez gagné "+r+" d'or\n"+">>> Or : "+inventaire.getOr());
                    tableDeButin();
                }
            }else if(seed < 9 && equipe.aDesVivants()){
                    repos();
            } else if(seed < 10) {
                    InventaireMarchand inventaireMarchand = new InventaireMarchand();
                    inventaireMarchand.shopping(scanner, inventaire, equipe);
            } else {
                System.out.println("Game Over !");
                System.out.println("[ENTRER] Revenir au menu principal\nAppuyer sur n'importe quelles touches pour quitter.");
                String choix = scanner.nextLine();
                if(choix.isEmpty()) Launcher.main(null);
                System.exit(0);
            }
        compteur++;
    }

    public void repos() {
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
                        i.regenererCourage(i.getCourageMax() - i.getCourage());
                    }
                }
                System.out.println("Toute votre equipe se regenere 50 de courage !");
            }
        }
        
    }

    public void tableDeButin() {
        int porteurDeCendre = (int)(100*Math.random());
        if(porteurDeCendre < 5) {
            inventaire.getInventaire().put(new PorteurdeCendre(), 1);
        }
    }

    public int getCompteur() {
        return compteur;
    }


}
