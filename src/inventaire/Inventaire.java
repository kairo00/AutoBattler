package src.inventaire;
import java.util.*;

import src.items.Item;
import src.jeu.gestions.Equipe;

public class Inventaire {

    private int or = 0;
    private HashMap<Item, Integer> inventaire;

    public Inventaire() {
        inventaire = new HashMap<>();
    }

    public void starterKit() {
    }

    public void utiliserItem(Item item, Equipe equipe) {
        if(supprimeItem(item, 1)) {
            item.effet(equipe);
            System.out.print("Vous avez utilisé : "+item.toString()+" ! ");
        }
    }

    public boolean utiliserItemNom(String nom ,Equipe equipe) {
        for(src.items.Item i : new HashMap<>(getInventaire()).keySet()) {
            if(i.getNom().equalsIgnoreCase(nom)) {
                utiliserItem(i, equipe);
                return true;
            }
        }
        return false;
    }

    public void ajoutItem(Item item, int nombre) {
        if(inventaire.get(item) != null) {
            int nb = inventaire.get(item);
            inventaire.put(item, nb+nombre);
        } else {
            inventaire.put(item, nombre);
        }
        if (inventaire.get(item) < 1) {
            inventaire.remove(item);
        }
    }


    public boolean supprimeItem(Item item, int nombre) {
        for(Item i : inventaire.keySet()) {
            if(i.equals(item)) {
                if(inventaire.get(i) >= nombre) {
                    int nombreActuel = inventaire.get(i)-nombre;
                    if(nombreActuel > 0) inventaire.put(item, nombreActuel);
                    else inventaire.put(item, 0);
                    return true;
                }
            }
        }
        System.out.println("Vous ne possedez pas l'item ou pas assez d'item!!");
        return false;
    }

    public void ajoutOr(int nombre) {
        or += nombre;
    }
    
    public void soustraireOr(int nombre) {
        or -= nombre;
    }

    public int getOr() {
        return or;
    }
    
    @Override
    public String toString() {
        String s = "+-------------:--------:-------------+ \n";
        s += "|             |        |             | \n";
        s += "|-------------|________|-------------| \n";
        s += "|                                    | \n";       
        for(Item i: inventaire.keySet()) {
            s += "| Item : "+i+"\t Nombre : "+inventaire.get(i)+"          |\n";
        }
        s+= "| Gold : "+getOr()+"                         |\n";
        s+= "+------------------------------------+";
        return s;
    }

    public HashMap<Item, Integer> getInventaire() {
        return inventaire;
    }
}