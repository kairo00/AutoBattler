
import java.util.*;

public class InventaireMarchand extends Inventaire{

    InventaireMarchand() {
        inventaire = new HashMap<>();
    }

    public void achatMarchand(Item item, InventaireJoueur inventaireJoueur, int nombre) {
        if(inventaireJoueur.getOr() >= nombre*100 && item.toString().equals("Potion")) {
            inventaireJoueur.soustraireOr(100);
            ajoutOr(100);
            inventaireJoueur.ajoutItem(item, nombre);
            supprimeItem(item, item.toString(), nombre);
            System.out.println("Marchand : Rien de mieux qu'une petite potion pour se remettre en pleine forme ! ");
            return;
        }
        if(inventaireJoueur.getOr() >= nombre*100 && item.toString().equals("Biere")) {
            inventaireJoueur.soustraireOr(100);
            ajoutOr(100);
            inventaireJoueur.ajoutItem(item, nombre);
            supprimeItem(item, item.toString(), nombre);
            System.out.println("Marchand : On a tous besoin d'un petit coup de boost ! ");
        }else{
            System.out.println("Marchand : T'as pas assez d'argent sale pauvre");
        }
    }

    public void venteMarchand(Item item, String nom, int nombre, InventaireJoueur inventaireJoueur) {
        inventaireJoueur.venteJoueur(item, nombre);
        ajoutItem(item, nombre);
    }

    public void shopping(Scanner scanner, InventaireJoueur inventaireJoueur, Equipe equipe) {
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
            int choix = scanner.nextInt();
            switch(choix) {
                case 1 -> { 
                    toString();
                    int random = (int)(2*Math.random());
                    if(random == 0) {
                        System.out.println("Marchand : J'ai un t'as de choses pour vous aujourd'hui !");
                    }else {
                        System.out.println(" Qu'est-ce qui vous ferait plaisir ?");
                    }
                    System.out.println("1. Potions");
                    System.out.println("2. Biere");
                    System.out.print(joueur+" : J'aimerais une/des ~");
                    String choix1 = scanner.next();
                    System.out.print("Marchand : Tres bien mon ami ! Combien en veux-tu ? ");
                    int choixNombre = scanner.nextInt();
                    switch(choix1) {
                        case "Potion" -> {
                            System.out.println(joueur+" : "+choixNombre+" Potion(s)");
                            item = new Potion();
                            achatMarchand(item, inventaireJoueur, choixNombre);
                        }
                        case "Biere" -> {
                            System.out.println(joueur+" : "+choixNombre+" Biere(s)");
                            item = new Biere();
                            achatMarchand(item, inventaireJoueur, choixNombre);
                        }
                    }
                }

                case 2 -> { 
                    System.out.println("Marchand : J'peux y jeter un oeil !");
                    inventaireJoueur.getInventaire();
                    System.out.print("- Quel item veux tu me vendre ? ");
                    String choix3 = scanner.next();
                    System.out.println("- Combien peux tu m'en fournir ? ");
                    int choixNombre = scanner.nextInt();
                    switch(choix3) {
                        case "Potion" -> { 
                            item = new Potion();
                            venteMarchand(item, choix3, choixNombre, inventaireJoueur);
                        }
                        case "Biere" -> { 
                            item = new Biere();
                            venteMarchand(item, choix3, choixNombre, inventaireJoueur);
                        }
                    }
                }

                case 3 -> System.out.println(inventaireJoueur.toString());
                case 4-> {
                    b = false;
                    System.out.print("Marchand : Revenez quand vous voulez et bon courage !");
                }
            }

        }
        

    }

    @Override
    public void starterKit() {
        inventaire.put(new Potion(), 10);
        inventaire.put(new Biere(), 10);
        ajoutOr(250);
    }
}