

public class Archer extends Combattant {

    Archer() {
        super(170, 55, 5, 60);
    }

    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantFaible();
        adversaire.damage(getAtk() - adversaire.getDef());

        if(getAtk() < adversaire.getDef()) {
            adversaire.damage(0);
        }
    }

}
