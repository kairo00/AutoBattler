package src.inventaire;
import java.util.*;

import src.items.*;

/**
 * La classe InventaireMarchand représente l'inventaire d'un marchand.
 * Elle gère les items à vendre, l'or du marchand et les transactions avec le joueur.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public class InventaireMarchand extends Inventaire{

    /**
     * Création de l'inventaire du marchand
     */ 
    public InventaireMarchand() {
        super();
        starterKit();
    }

    /**
     * Permet l'achat d'items au marchand
     * @param item acheter auprès du marchant
     * @param nombre d'items voulu par le joueur
     * @param inventaireJoueur pour ajouter les produits achetés à l'inventaire du joueur
     */ 
     public void achatMarchand(Item item, int nombre, InventaireJoueur inventaireJoueur) {
        //Si l'or du joueur est supérieur à la valeur du/des item(s) demandé(s)
        if(inventaireJoueur.getOr() >= nombre*item.getValeurVente()) {
            //Soustraction de l'or dans l'inventaire du joueur
            inventaireJoueur.soustraireOr(item.getValeurVente()*nombre);
            //Ajout d'or dans l'inventaire du marchant
            ajoutOr(item.getValeurVente()*nombre);
            //Ajoute le/les item(s) acheté(s) par le joueur dans son inventaire
            inventaireJoueur.ajoutItem(item, nombre);
            //Soustrait/Supprime l'item en question de l'inventaire du marchand
            supprimeItem(item, nombre);
            //Dialogue en fonction de l'achat
            switch(item.getNom().toLowerCase()) {
                case "potion" -> System.out.println("Marchand : Rien de mieux qu'une petite potion pour se remettre en pleine forme ! ");
                case "biere" -> System.out.println("Marchand : On a tous besoin d'un petit coup de boost ! ");
                case "these" -> System.out.println("Marchand : Un choix interessant ... ");
            }
        } else {
            //Dialogue si le joueur n'a pas assez d'argent
            System.out.println("Marchand : T'as pas assez d'argent sale pauvre !\n >>> Requis :"+ nombre*item.getValeurVente() + "\n>>> Ton solde: "+inventaireJoueur.getOr());
        }
    }

    /**
     * Permet au joueur de vendre ses items auprès du marchand
     * @param item vendu auprès du joueur
     * @param nombre d'items vendus voulus par le joueur
     * @param inventaireJoueur pour ajouter l'or dans l'inventaire en fonction de la valeur de l'item vendu
     */ 
    public void venteMarchand(Item item, int nombre, InventaireJoueur inventaireJoueur) {
        //Si le marchand possède suffisament d'argent il achète l'item
        if(getOr() >= nombre*item.getValeurRevente()) {
            inventaireJoueur.venteJoueur(item, nombre);
            //Ajout de l'item dans l'inventaire du marchand
            ajoutItem(item, nombre);
        } else {
            //Dialogue si le marchand n'a pas assez d'argent
            System.out.println("Joueur : Je crois qu'il te manque un peu d'argent pour m'acheter ça !");
        }
    }

    /**
     * Quantité d'objets/d'or disponibles chez le marchand, générée aléatoirement
     */ 
    @Override
    public void starterKit() {
        List<Item> itemsDisponibles = Item.getItemsDisponibles();
        for (Item item : itemsDisponibles) {
            int quantite = (int) (Math.random() * 5);
            getInventaire().put(item, quantite);
        }
        ajoutOr(250);
    }

    /**
     * Affichage de l'inventaire du marchand
     * @return la chaine de caractère pour afficher l'inventaire dans le terminal
     */ 
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