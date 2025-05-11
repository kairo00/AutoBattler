package src.inventaire;
import java.util.*;

import src.items.Item;
import src.jeu.gestions.Equipe;

/**
 * La classe Inventaire représente l'inventaire d'un joueur dans le jeu.
 * Gère les objets et l'or du joueur.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public abstract class Inventaire {

    //Initialisation de l'or et de l'inventaire sous forme d'une HashMap
    private int or = 0;
    private HashMap<Item, Integer> inventaire;

    /**
     * Constructeur de la classe Inventaire.
     * Initialise l'inventaire sous forme d'une HashMap.
     */
    public Inventaire() {
        inventaire = new HashMap<>();
    }

    //Genere des items en debut de partie en fonction de si c'est un joueur ou un pnj
    public abstract void starterKit();

    /**
     * Si l'item est supprimé alors il est utilisé donc les effets de l'objet s'applique
     * @param item à utiliser
     * @param equipe recoit l'effet correspondant à l'item utilisé
     */
    public void utiliserItem(Item item, Equipe equipe) {
        if(supprimeItem(item, 1)) {
            item.effet(equipe);
            System.out.print("Vous avez utilisé : "+item.toString()+" ! ");
        }
    }

    /**
     * Utilisation d'un objet en fonction du nom de l'item
     * @param nom de l'item à utiliser
     * @param equipe recoit l'effet correspondant à l'item utilisé
     * @return true si l'objet est utilisé sinon false
     */ 
    public boolean utiliserItemNom(String nom, Equipe equipe) {
        //boucle for-each qui itère dans les Items
        for(src.items.Item i : new HashMap<>(getInventaire()).keySet()) {
            //si le nom de l'item  correspond à un des noms dans la HashMap alors fait appelle à la méthode utiiserItem et renvoie vraie
            if(i.getNom().equalsIgnoreCase(nom)) {
                utiliserItem(i, equipe);
                return true;
            }
        }
        return false;
    }

    /**
     * Utilisation d'un objet en fonction du nom de l'item
     * @param nom de l'item à utiliser
     * @param equipe recoit l'effet correspondant à l'item utilisé
     * @return true si l'objet est utilisé sinon false
     */ 
    public void ajoutItem(Item item, int nombre) {
        //Si l'item existe dans l'inventaire alors on l'ajoute en plus du nombre d'items déjà présents
        if(inventaire.get(item) != null) {
            int nb = inventaire.get(item);
            inventaire.put(item, nb+nombre);
        //Ajout de l'item
        } else {
            inventaire.put(item, nombre);
        }
        //Lorsque l'item n'est plus disponible dans l'inventaire (<1) il est retiré de la HashMap
        if (inventaire.get(item) < 1) {
            inventaire.remove(item);
        }
    }


    /**
     * Supprime un item si l'es conditions sont remplies
     * @param item à supprimer
     * @param nombre d'item à éliminer
     * @return true si l'objet est supprimé sinon false
     */ 
    public boolean supprimeItem(Item item, int nombre) {
        //Iteration parmi les items 
        for(Item i : inventaire.keySet()) {
            //Recherche de l'item dans la liste
            if(i.equals(item)) {
                //Soustraction des items si le nombre présent dans l'inventaire est supérieur au nombre en paramètre
                if(inventaire.get(i) >= nombre) {
                    //Actualisation du nombre d'items
                    int nombreActuel = inventaire.get(i)-nombre;
                    //Ajoute le nombre d'items restants à l'inventaire si > 0
                    if(nombreActuel > 0) inventaire.put(item, nombreActuel);
                    //Sinon ajoute 0
                    else inventaire.put(item, 0);
                    return true;
                }
            }
        }
        //Si l'item n'est pas trouvé alors message d'erreur
        System.out.println("Vous ne possedez pas l'item ou pas assez d'item!!");
        return false;
    }

    /**
     * Ajout d'or en fonction de la valeur
     * @param nombre d'or ajouté
     */ 
    public void ajoutOr(int nombre) {
        or += nombre;
    }
    
    /**
     * Soustraction de l'or en fonction de la valeur
     * @param nombre d'or à soustraire
     */ 
    public void soustraireOr(int nombre) {
        or -= nombre;
    }
    
    /**
     * Affichage de l'inventaire
     * @return la chaine de caractère pour afficher l'inventaire dans le terminal
     */ 
    @Override
    public String toString() {
        String s = "+-------------:--------:-------------+ \n";
        s += "|             |        |             | \n";
        s += "|-------------|________|-------------| \n";
        s += "|                                    | \n";       
        for(Item i: inventaire.keySet()) {
            s += "| Item : "+i.getNom()+"\t Nombre : "+inventaire.get(i)+"          |\n";
        }
        s+= "| Gold : "+getOr()+"                         |\n";
        s+= "+------------------------------------+";
        return s;
    }

    /* Getters */
    public HashMap<Item, Integer> getInventaire() {
        return inventaire;
    }

    public int getOr() {
        return or;
    }
}