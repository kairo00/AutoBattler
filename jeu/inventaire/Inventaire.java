package jeu.inventaire;
import java.util.*;
import jeu.gestions.Equipe;
import jeu.items.Item;

public class Inventaire {

    private int or = 0;

    HashMap<Item, Integer> inventaire;

    public Inventaire() {
        inventaire = new HashMap<>();
    }

    public HashMap<Item, Integer> getInventaire() {
        return inventaire;
    }

    public void starterKit() {
    }

    public void utiliserItem(Item item, Equipe equipe) {
        if(supprimeItem(item, item.toString(), 1)) {
            item.effet(equipe);
            System.out.print("Vous avez utilisé : "+item.toString()+" ! ");
        }
    }

    public void ajoutItem(Item item, int nombre) {
        for(Item i : inventaire.keySet()) {
            if(i.toString().equals(item.toString())) {
                int nombreActuel = inventaire.get(i)+nombre;
                inventaire.remove(i);
                inventaire.put(item, nombreActuel);
                if(nombreActuel < 1) {
                    inventaire.remove(i);
                }
            }
        }
    }


    public boolean supprimeItem(Item item, String nom, int nombre) {
        for(Item i : inventaire.keySet()) {
            if(i.toString().equals(nom)) {
                int nombreActuel = inventaire.get(i)-nombre;
                inventaire.remove(i);
                inventaire.put(item, nombreActuel);
                if(nombreActuel < 1) {
                    inventaire.remove(i);
                }
                return true;
            }else{
                System.out.println("Vous ne possedez pas l'item");
                return false;
            }
        }
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
}
package jeu.inventaire;
import java.util.*;
import jeu.gestions.Equipe;
import jeu.items.Item;

public class Inventaire {

    private int or = 0;

    HashMap<Item, Integer> inventaire;

    public Inventaire() {
        inventaire = new HashMap<>();
    }

    public HashMap<Item, Integer> getInventaire() {
        return inventaire;
    }

    public void starterKit() {
    }

    public void utiliserItem(Item item, Equipe equipe) {
        if(supprimeItem(item, item.toString(), 1)) {
            item.effet(equipe);
            System.out.print("Vous avez utilisé : "+item.toString()+" ! ");
        }
    }

    public void ajoutItem(Item item, int nombre) {
        for(Item i : inventaire.keySet()) {
            if(i.toString().equals(item.toString())) {
                int nombreActuel = inventaire.get(i)+nombre;
                inventaire.remove(i);
                inventaire.put(item, nombreActuel);
                if(nombreActuel < 1) {
                    inventaire.remove(i);
                }
            }
        }
    }


    public boolean supprimeItem(Item item, String nom, int nombre) {
        for(Item i : inventaire.keySet()) {
            if(i.toString().equals(nom)) {
                int nombreActuel = inventaire.get(i)-nombre;
                inventaire.remove(i);
                inventaire.put(item, nombreActuel);
                if(nombreActuel < 1) {
                    inventaire.remove(i);
                }
                return true;
            }else{
                System.out.println("Vous ne possedez pas l'item");
                return false;
            }
        }
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
        String s = "+--------------[Inventaire]--------------+ \n";
        for(Item i: inventaire.keySet()) {
            s += "Item : "+i+"\t Nombre : "+inventaire.get(i)+"\n";
        }
        s+= "Gold : "+getOr()+"\n";
        s+= "+------------------------------------+";
        return s;
    }
}