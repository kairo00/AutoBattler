

public class Archer extends Combattant {

    Archer() {
        super(170, 55, 5, 60);
    }

    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantFaible();
        adversaire.damage(this);
    }

    @Override
    public String toString() {
        return "A["+getPV()+"/170]";
    }

    public String getNom() {
        return "Archer";
    }
}
