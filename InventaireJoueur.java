
import java.util.HashMap;

public class InventaireJoueur extends Inventaire {

    public InventaireJoueur() {
        inventaire = new HashMap<>();
    }

    public void venteJoueur(Item item, int nombre) {
        supprimeItem(item, item.toString(), nombre);
        ajoutOr(item.getValeur());
    }
    
    @Override
    public void starterKit() {
        inventaire.put(new Potion(), 1);
        inventaire.put(new Biere(), 1);
        ajoutOr(100);
    }
}