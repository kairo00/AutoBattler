import java.util.*;

public class Inventaire {

    HashMap<String, Integer> inventaire;

    public Inventaire() {
        inventaire = new HashMap<>();
    }

    public HashMap getInventaire() {
        return inventaire;
    }

    public void starterKit() {
        inventaire.put("gold", 100);
        inventaire.put("potion", 1);
    }

    public void ouvrirInventaire() {
        for(String i : inventaire.keySet()) {
            System.out.println("Objet : "+i+"\t Quantité : "+inventaire.get(i));
        }
    }

    
}