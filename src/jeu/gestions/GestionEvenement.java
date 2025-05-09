package src.jeu.gestions;
import java.util.*;

import src.Launcher;
import src.entitees.Combattant;
import src.entitees.boss.Monika;
import src.entitees.boss.Nashor;
import src.entitees.boss.Ragnaros;
import src.entitees.boss.Sanguinius;
import src.entitees.miniboss.Graymarrow;
import src.entitees.miniboss.Herald;
import src.entitees.miniboss.KingSlime;
import src.entitees.mobs.Cultist;
import src.entitees.mobs.Demon;
import src.entitees.mobs.Diablotin;
import src.inventaire.InventaireJoueur;
import src.inventaire.InventaireMarchand;
import src.items.Biere;
import src.items.Item;
import src.items.PorteurdeCendre;
import src.items.Potion;
import src.items.These;

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
                case 0 -> groupe.ajouterCombattant(new Diablotin());
                case 1 -> groupe.ajouterCombattant(new Cultist());
                case 2 -> groupe.ajouterCombattant(new Demon());
            }
        }
    }

    public void genererMiniBoss(Equipe boss) {
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

        public static void genererBoss(Equipe boss) {
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

    public void eventMarchand() {
        InventaireMarchand marchand = new InventaireMarchand();  
        Item item;
        String joueur = equipe.choisirCombattantAleatoire().getNom();
        System.out.print("Marchand :  Soyez les Bienvenues voyageurs !");
        System.out.println(" Que puis-je faire pour vous ?");
        boolean b = true;
        while(b) {
            System.out.println("1. Achat");
            System.out.println("2. Vente");
            System.out.println("3. Consulter son inventaire");
            System.out.println("4. Quitter");
            int choix = UtilitaireJeu.saisieMenu(scanner, 1, 4);
            switch(choix) {
                case 1 -> { 
                    int random = (int)(2*Math.random());
                    if(random == 0) {
                        System.out.println("Marchand : J'ai un t'as de choses pour vous aujourd'hui !");
                    }else {
                        System.out.println(" Qu'est-ce qui vous ferait plaisir ?");
                    }
                    System.out.println(marchand.toString());
                    System.out.println(">>> Votre solde : "+inventaire.getOr()+" d'or");
                    System.out.print(joueur+" : J'aimerais une/des ~");
                    String choix1 = scanner.next();
                    System.out.print("Marchand : Tres bien mon ami ! Combien en veux-tu ? ");
                    int choixNombre = scanner.nextInt();
                    switch(choix1.toLowerCase()) {
                        case "potion" -> {
                            System.out.println(joueur+" : "+choixNombre+" Potion(s)");
                            item = new Potion();
                            marchand.achatMarchand(item, choixNombre, inventaire);
                        }
                        case "biere" -> {
                            System.out.println(joueur+" : "+choixNombre+" Biere(s)");
                            item = new Biere();
                            marchand.achatMarchand(item, choixNombre, inventaire);
                        }
                        case "these" -> {
                            System.out.println(joueur+" : "+choixNombre+" These(s)");
                            item = new These();
                            marchand.achatMarchand(item, choixNombre, inventaire);
                        }
                        default -> {
                            System.out.println("Marchand: Désolé je ne vend pas de "+choix1+"...Tu ne t'es pas trompé dans l'orthographe ?");
                        }
                    }
                }

                case 2 -> { 
                    System.out.println("Marchand : J'peux y jeter un oeil !");
                    inventaire.getInventaire();
                    System.out.println("- Quel item veux tu me vendre ? ");
                    for(Item i : inventaire.getInventaire().keySet()) {
                        System.out.println("Item: "+i.getNom()+"\t Nombre : "+inventaire.getInventaire().get(i)+"\t Prix de vente : "+i.getValeurRevente());
                    }
                    String choix3 = scanner.next();
                    System.out.println("- Combien peux tu m'en fournir ? ");
                    int choixNombre = scanner.nextInt();
                    switch(choix3.toLowerCase()) {
                        case "potion" -> { 
                            item = new Potion();
                            marchand.venteMarchand(item, choixNombre, inventaire);
                        }
                        case "biere" -> { 
                            item = new Biere();
                            marchand.venteMarchand(item, choixNombre, inventaire);
                        }
                        case "these" -> {
                            System.out.println(joueur+" : "+choixNombre+" These(s)");
                            item = new These();
                            marchand.venteMarchand(item, choixNombre, inventaire);
                        }
                    }
                }

                case 3 -> System.out.println(inventaire.toString());
                case 4-> {
                    b = false;
                    System.out.print("Marchand : Revenez quand vous voulez et bon courage !");
                }
            }

        }
        

    }

    public void tableDeButin() {
        int porteurDeCendre = (int)(100*Math.random());
        if(porteurDeCendre < 5) {
            inventaire.getInventaire().put(new PorteurdeCendre(), 1);
        }
    }

    public void prochainEvent() {
        int seed = (int)(10*Math.random());
        if(compteur%10 == 0 && equipe.aDesVivants()) {
            Equipe boss = new Equipe();
            genererMobs(boss);
            Combat arene = new Combat(equipe, boss, scanner);
            arene.lancerCombat();
            if(!equipe.aDesVivants()) arreterJeu();
            else ajoutOr();
        }else if(compteur == 5 && equipe.aDesVivants()) {
            Equipe miniBoss = new Equipe();
            genererMiniBoss(miniBoss);
            Combat arene = new Combat(equipe, miniBoss, scanner);
            arene.lancerCombat();
            if(!equipe.aDesVivants()) arreterJeu();
            else ajoutOr(); 
        }else if(seed < 7 && equipe.aDesVivants()){
            Equipe mobs = new Equipe();
            genererMobs(mobs);
            Combat arene = new Combat(equipe, mobs, scanner);
            arene.lancerCombat();
                if(!equipe.aDesVivants()) arreterJeu();
                else ajoutOr();
            }else if(seed < 9 && equipe.aDesVivants()){
                    repos();
            } else if(seed < 10) {
                    eventMarchand();
            } else {
                arreterJeu();
            }
        compteur++;
    }

    private void arreterJeu() {
            System.out.println("Votre équipe a été vaincue !");
            System.out.println("[ENTRER] Revenir au menu principal\nAppuyer sur n'importe quelles touches pour quitter.");
            String choix = scanner.nextLine();
            if(choix.isEmpty()) Launcher.main(null);
            System.exit(0);
    }

    private void ajoutOr() {
        int r = (int)(80*Math.random());
        inventaire.ajoutOr(r);
        System.out.println("Vous avez gagné "+r+" d'or\n"+">>> Or : "+inventaire.getOr());
        tableDeButin();
    }

    public int getCompteur() {
        return compteur;
    }


}
