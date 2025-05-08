package src.items;
import src.jeu.gestions.Equipe;

public class Item {
    private String nom;
    private String type;
    private int valeur;

    Item(String nom, String type, int valeur) {
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
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

    public int getValeur() {
        return valeur;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }
}