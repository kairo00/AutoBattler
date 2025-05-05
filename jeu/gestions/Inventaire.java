package jeu.gestions;

import java.util.HashMap;

public class Inventaire {

    private HashMap<String, Integer> inventaire;

    public Inventaire() {
        inventaire = new HashMap<>();
    }

    public HashMap<String, Integer> getInventaire() {
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