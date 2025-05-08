package src.inventaire;
import src.items.*;

public class InventaireJoueur extends Inventaire {

    public InventaireJoueur() {
        super();
    }

    public void venteJoueur(Item item, int nombre) {
        if(supprimeItem(item, nombre)) ajoutOr(item.getValeur()*nombre);
    }
    
    @Override
    public void starterKit() {
        getInventaire().put(new Potion(), 1);
        getInventaire().put(new Biere(), 1);
        ajoutOr(100);
    }
}