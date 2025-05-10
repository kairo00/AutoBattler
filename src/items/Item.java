package src.items;
import java.util.List;
import src.jeu.gestions.Equipe;

public abstract class Item {
    private String nom;
    private String type;
    private int valeurRevente, valeurVente;

    /**
     * Création de l'objet item
     */
    Item(String nom, String type, int valeurVente, int valeurRevente) {
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
     * @return 
     */
    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    /**
     * Renvoie une liste des items disponibles
     * @return la liste d'objets disponibles
     */
    public static List<Item> getItemsDisponibles() {
        return List.of(
            new Potion(),
            new Biere(),
            new These(),
            new PorteurdeCendre()
        );
    }

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

    @Override
    public String toString() {
        return nom;
    }
}