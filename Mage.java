

public class Mage extends Combattant {

    Mage() {
        super(160, 70, 0, 30);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.damage(getAtk(), this);
    }

    @Override
    public String toString() {
        return "M["+getPV()+"/160]";
    }

    public String getNom() {
        return "Mage";
    }
}