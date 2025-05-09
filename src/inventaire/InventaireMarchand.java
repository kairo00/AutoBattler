package src.inventaire;
import java.util.*;

import src.items.*;


public class InventaireMarchand extends Inventaire{

    public InventaireMarchand() {
        super();
        starterKit();
    }

    public void achatMarchand(Item item, int nombre, InventaireJoueur inventaireJoueur) {
        if(inventaireJoueur.getOr() >= nombre*item.getValeurVente()) {
            inventaireJoueur.soustraireOr(item.getValeurVente()*nombre);
            ajoutOr(item.getValeurVente()*nombre);
            inventaireJoueur.ajoutItem(item, nombre);
            supprimeItem(item, nombre);
            switch(item.getNom().toLowerCase()) {
                case "potion" -> System.out.println("Marchand : Rien de mieux qu'une petite potion pour se remettre en pleine forme ! ");
                case "biere" -> System.out.println("Marchand : On a tous besoin d'un petit coup de boost ! ");
                case "these" -> System.out.println("Marchand : Un choix interessant ... ");
            }
            return;
        } else {
            System.out.println("Marchand : T'as pas assez d'argent sale pauvre !\n >>> Requis :"+ nombre*item.getValeurVente() + "\n>>> Ton solde: "+inventaireJoueur.getOr());
        }
    }

    public void venteMarchand(Item item, int nombre, InventaireJoueur inventaireJoueur) {
        if(getOr() >= nombre*item.getValeurRevente()) {
            inventaireJoueur.venteJoueur(item, nombre);
            ajoutItem(item, nombre);
            System.out.println("Je te le reprends pour "+item.getValeurRevente()*nombre+" pieces d'or ! Merci !");
        } else {
            System.out.println("Joueur : Je crois qu'il te manque un peu d'argent pour m'acheter ça !");
        }
    }

    @Override
    public void starterKit() {
        List<Item> itemsDisponibles = Item.getItemsDisponibles();
        for (Item item : itemsDisponibles) {
            int quantite = (int) (Math.random() * 5);
            getInventaire().put(item, quantite);
        }
        ajoutOr(250);
    }

    @Override
    public String toString() {
        String s = "+-------------:--------:-------------+ \n";    
        for(Item i: getInventaire().keySet()) {
            s += "| Item : "+i.getNom()+"\t Nombre : "+getInventaire().get(i)+"\t Prix : "+i.getValeurVente()+"         |\n";
        }
        s+= "+------------------------------------+";
        return s;
    }
}