public class Item {
    String nom;
    String type;
    int valeur;

    Item(String nom, String type, int valeur) {
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
    }

    public void effet(Equipe equipe) {
    }

    @Override
    public String toString() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }
}