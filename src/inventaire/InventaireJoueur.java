package src.inventaire;
import src.items.*;

/**
 * Classe qui représente l'inventaire du joueur.
 * (hérite de la classe Inventaire)
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Inventaire
 */
public class InventaireJoueur extends Inventaire {

    /**
     * Création de l'inventaire du joueur
     */ 
    public InventaireJoueur() {
        super();
    }

    /**
     * Permet de vendre un item au marchand
     * @param item item à vendre
     * @param nombre nombre d'items à vendre
     */
    public void venteJoueur(Item item, int nombre) {
        //Si le joueur possède suffisament d'items à vendre, alors il y a transaction
        if(supprimeItem(item, nombre)) { 
            ajoutOr(item.getValeurRevente()*nombre);
            System.out.println("Marchand: Je te le reprends pour "+item.getValeurRevente()*nombre+" pieces d'or ! Merci !");
        }

    }
    
    /**
     * Items/or disponible dès le début de la partie dans l'inventaire du joueur
     */ 
    @Override
    public void starterKit() {
        getInventaire().put(new Potion(), 1);
        getInventaire().put(new Biere(), 1);
        ajoutOr(100);
    }
}