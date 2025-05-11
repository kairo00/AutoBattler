package src.jeu.gestions;

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

/**
 * Cette classe gère les événements du jeu.
 * Elle permet de générer des mobs, des mini-boss, des boss, de gérer les événements de repos, de marchand et de butin.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public class GestionEvenement {
    private Equipe equipe;
    private InventaireJoueur inventaire;

    private int compteur = 1;

    /**
     * Gère les différents evenements possibles
     * @param equipe du joueur
     * @param inventaire du joueur
     */
    public GestionEvenement(Equipe equipe, InventaireJoueur inventaire) {
        this.equipe = equipe;
        this.inventaire = inventaire;
    }

    /**
     * Génère un groupe aléatoire de mobs (entre 3 et 6)
     * @param groupe de mobs
     */
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

        /**
     * Génère un mini-boss aléatoire
     * @param boss une équipe de boss
     */
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

    /**
     * Génère boss aléatoire
     * @param boss une équipe de boss
     */
    public void genererBoss(Equipe boss) {
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

    /**
     * Zone de repos : espace où le joueur peut régénérer
     */
    public void evenementRepos() {
        System.out.println("Votre groupe a trouvé une zone de repos !");
        System.out.println("1. Se reposer et se soigner");
        System.out.println("2. Se raconter des histoires et regagner du courage");
        int choix = UtilitaireJeu.saisirInt();
        switch(choix) {
            case 1 -> {
                for(Combattant i : equipe.getEquipe()) {
                    if(i.getPvMax() < i.getPV() - 50) {
                        i.regenererPV(50);
                    }else {
                        i.regenererPV(i.getPvMax() - i.getPV());
                    }
                }
                System.out.println("Toute votre equipe se regenere de 50 hp !💞");
            }
            case 2 -> {
                for(Combattant i : equipe.getEquipe()) {
                    if(i.getCourageMax() < i.getCourage() - 50) {
                        i.regenererCourage(50);
                    }else {
                        i.regenererCourage(i.getCourageMax() - i.getCourage());
                    }
                }
                System.out.println("Toute votre equipe se regenere 50 de courage !⚡️");
            }
        }
        
    }

    /**
     * Zone du marchand : gère l'interaction entre le joueur et le marchand
     */
    public void evenementMarchand() {
        //Initialisation de l'inventaire du marchand
        InventaireMarchand marchand = new InventaireMarchand();  
        Item item;
        //Choisie aléatoirement le combattant qui va parler au marchand
        String joueur = equipe.choisirCombattantAleatoire().getNom();

        //Dialogue d'acceuil du marchand
        System.out.print("Marchand :  Soyez les Bienvenues voyageurs !");
        System.out.println(" Que puis-je faire pour vous ?");
        boolean marchandLance = true;

        //Menu d'interaction
        while(marchandLance) {
            System.out.println("1. Achat");
            System.out.println("2. Vente");
            System.out.println("3. Consulter son inventaire");
            System.out.println("4. Quitter");

             //Le joueur saisie l'action qu'il veut réaliser
            int choix = UtilitaireJeu.saisieMenu(1, 4);
            switch(choix) {

                //Option 1: Achat aupres du marchand
                case 1 -> { 
                    //Tirage pour savoir quel dialogue le marchand va utiliser
                    int random = (int)(2*Math.random());
                    if(random == 0) {
                        System.out.println("Marchand : J'ai un t'as de choses pour vous aujourd'hui !");
                    }else {
                        System.out.println(" Qu'est-ce qui vous ferait plaisir ?");
                    }

                    //Affichage de l'inventaire du marchand
                    System.out.println(marchand.toString());
                    System.out.println(">>> Votre solde : "+inventaire.getOr()+" d'or");
                                        //Le joueur tape le nom de l'item qu'il veut obtenir
                    System.out.print(joueur+" : J'aimerais une/des ~");
                    String choix1 = UtilitaireJeu.scanner.nextLine();
                     //Le joueur tape le nombre d'item qu'il veut obtenir
                    System.out.print("Marchand : Tres bien mon ami ! Combien en veux-tu ? ");
                    int choixNombre = UtilitaireJeu.saisirInt();
                    // En fonction de son choix, un dialogue apparaît et le joueur obtient le nombre d'items demandé
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
                        // Si l'orthographe est incorrecte, renvoie un message d'erreur
                        default -> {
                            System.out.println("Marchand: Désolé je ne vend pas de "+choix1+"...Tu ne t'es pas trompé dans l'orthographe ?");
                        }
                    }
                }

                 //Option 2: Vente d'item au marchand
                case 2 -> { 
                    System.out.println("Marchand : J'peux y jeter un oeil !");
                    inventaire.getInventaire();
                    System.out.println("- Quel item veux tu me vendre ? ");
                    //Ouvre l'inventaire du joueur
                    for(Item i : inventaire.getInventaire().keySet()) {
                        System.out.println("Item: "+i.getNom()+"\t Nombre : "+inventaire.getInventaire().get(i)+"\t Prix de vente : "+i.getValeurRevente());
                    }
                     //Le joueur tape le nom de l'item à vendre
                    String choix3 = UtilitaireJeu.scanner.nextLine();
                    //le joueur tape le nombre d'item à vendre
                    System.out.println("- Combien peux tu m'en fournir ? ");
                    int choixNombre = UtilitaireJeu.saisirInt();
                    //Vend l'item choisi
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
                //Option 3
                //Affiche l'inventaire du joueur
                case 3 -> System.out.println(inventaire.toString());
                //Option 4
                //Quitter l'interaction avec le marchand
                case 4-> {
                    marchandLance = false;
                    System.out.print("Marchand : Revenez quand vous voulez et bon courage !");
                }
            }

        }
        

    }

    /**
     * Gère le taux de loot des items
     */
    public void genererTableDeButin() {
        int porteurDeCendre = (int)(100*Math.random());
        if(porteurDeCendre < 5) {
            System.out.println("Vous avez trouvé un Porteur de Cendre ! *Extension de l'inventaire*");
            inventaire.getInventaire().put(new PorteurdeCendre(), 1);
        }
    }

    /**
     * Gère les différents évènements possibles
     */
    public void prochainEvenement() {
        //Tirage pour définir le prochain évènement
        int seed = (int)(10*Math.random());
        //Si la manche est un multiple de 10 alors un boss apparait et un combat se lance
        if(compteur%10 == 0 && equipe.aDesVivants()) {
            Equipe boss = new Equipe();
            genererBoss(boss);
            Combat arene = new Combat(equipe, boss);
            arene.lancerCombat();
            //Si les combattants sont morts alors fin du jeu
            if(!equipe.aDesVivants()) arreterJeu();
            //Si le joueur remporte le combat alors il reçoit de l'or
            else ajoutOr();
        //Si la manche est un multiple de 5 alors un mini-boss apparait et un combat se lance
        }else if(compteur%5 == 0 && equipe.aDesVivants()) {
            Equipe miniBoss = new Equipe();
            genererMiniBoss(miniBoss);
            Combat arene = new Combat(equipe, miniBoss);
            arene.lancerCombat();
            //Si les combattants sont morts alors fin du jeu
            if(!equipe.aDesVivants()) arreterJeu();
            //Si le joueur remporte le combat alors il reçoit de l'or
            else ajoutOr(); 
        //Si la seed est inférieur à 7 alors un groupe de monstres apparait et un combat se lance
        }else if(seed < 7 && equipe.aDesVivants()){
            Equipe mobs = new Equipe();
            genererMobs(mobs);
            Combat arene = new Combat(equipe, mobs);
            arene.lancerCombat();
                //Si les combattants sont morts le combat s'arrête
                if(!equipe.aDesVivants()) arreterJeu();
                //Si le joueur remporte le combat il gagne de l'or
                else ajoutOr();
            //Si la seed est egale à 7 alors une zone de repos apparait
            }else if(seed < 8 && equipe.aDesVivants()){
                    evenementRepos();
            //Si la seed est entre 8 et 9 une zone marchand apparait
            } else if(seed < 10) {
                    evenementMarchand();
            //Sinon le jeu s'arrête
            } else {
                arreterJeu();
            }
        //Augmentation du compteur de manche
        compteur++;
    }

    /**
     * Si l'équipe est vaincu alors le jeu s'arrête et retour au menu
     */
    private void arreterJeu() {
            System.out.println("Votre équipe a été vaincue !");
            System.out.println("[ENTRER] Revenir au menu principal");
            UtilitaireJeu.scanner.nextLine();
            Launcher.main(null);
            return;
    }

    /**
     * Le joueur gagne de l'or/item après chaque combat remporté
     */
    private void ajoutOr() {
        //Tirage de l'or que le joueur va remporter
        int r = (int)(80*Math.random());
        //Ajout de l'or
        inventaire.ajoutOr(r);
        System.out.println("Vous avez gagné "+r+" d'or\n"+">>> Or : "+inventaire.getOr());
        //Chance d'obtenir un item à la fin d'un combat
        genererTableDeButin();
    }

    /**
     * Getter de l'inventaire du joueur
     * @return l'inventaire du joueur
     */
    public int getCompteur() {
        return compteur;
    }


}
