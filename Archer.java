

public class Archer extends Combattant {

    Archer() {
        super(170, 55, 5, 60, 100);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantFaible();
        adversaire.damage(this);
    }

    @Override
    public String toString() {
        return "A["+getPV()+"/170]";
    }

    @Override
    public String getNom() {
        return "Archer";
    }
}
