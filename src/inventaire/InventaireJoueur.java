package src.inventaire;
import src.items.*;

public class InventaireJoueur extends Inventaire {

    /**
     * Création de l'inventaire du joueur
     */ 
    public InventaireJoueur() {
        super();
    }

    /**
     * Permet au joueur de vendre des items
     * @param item à vendre
     * @param nombre d'item à vendre
     */ 
    public void venteJoueur(Item item, int nombre) {
        //Si le joueur possède suffisament d'items à vendre, alors il y a transaction
        if(supprimeItem(item, nombre)) ajoutOr(item.getValeurRevente()*nombre);
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