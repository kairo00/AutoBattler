package src.items;
import src.jeu.gestions.Equipe;
import java.util.List;

/**
 * Classe abstraite représentant un item dans le jeu.
 * Chaque item a un nom, un type, une valeur de vente et une valeur de revente.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public abstract class Item {
    private String nom;
    private String type;
    private int valeurRevente, valeurVente;

    /**
     * Constructeur de la classe Item.
     * 
     * @param nom le nom de l'item
     * @param type le type de l'item
     * @param valeurVente la valeur de vente de l'item
     * @param valeurRevente la valeur de revente de l'item
     */
    public Item(String nom, String type, int valeurVente, int valeurRevente) {
        this.nom = nom;
        this.type = type;
        this.valeurVente = valeurVente;
        this.valeurRevente = valeurRevente;
    }

    /**
     * Initialisation d'une méthode pour activer l'effet des items 
     * @param equipe qui bénéfira de l'effet
     */
    public abstract void effet(Equipe equipe);

    /**
     * Surchage de equals
     * @param o pour comparer à l'objet courant
     * @return true si o et this sont égaux sinon false
     */
    @Override
    public boolean equals(Object o) {
        //Si les deux items sont identiques renvoie vrai
        if (this == o) return true;
        //Si l'object est null ou d'une classe différente
        if (o == null || getClass() != o.getClass()) return false;
        Item i = (Item) o;
        //Compare le nom des deux objets
        return nom.equals(i.nom);
    }

        /**
     * Surcharge de hashCode pour la méthode equals 
     * @return le hashCode de l'objet (int)
     */
    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return nom;
    }

    /**
     * Renvoie une liste des items disponibles (getters)
     * @return la liste d'objets disponibles
     */
    public static List<Item> getItemsDisponibles() {
        return List.of(
            new Potion(),
            new Biere(),
            new These()
        );
    }

    /*Getters*/
    public int getValeurRevente() {
        return valeurRevente;
    }
    
    public int getValeurVente() {
        return valeurVente;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }
}