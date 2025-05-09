package src.items;
import src.jeu.gestions.Equipe;
import java.util.List;

public class Item {
    private String nom;
    private String type;
    private int valeurRevente, valeurVente;

    Item(String nom, String type, int valeurVente, int valeurRevente) {
        this.nom = nom;
        this.type = type;
        this.valeurVente = valeurVente;
        this.valeurRevente = valeurRevente;
    }

    public void effet(Equipe equipe) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item i = (Item) o;
        return nom.equals(i.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return nom;
    }

    public static List<Item> getItemsDisponibles() {
        return List.of(
            new Potion(),
            new Biere(),
            new These()
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
}