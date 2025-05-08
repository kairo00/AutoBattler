package jeu.items;
import jeu.gestions.Equipe;

public abstract class Item {
    String nom;
    String type;
    int valeur;

    Item(String nom, String type, int valeur) {
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
    }

    public abstract void effet(Equipe equipe);

    @Override
    public String toString() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }
}