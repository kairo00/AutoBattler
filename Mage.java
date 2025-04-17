

public class Mage extends Combattant {

    Mage() {
        super(160, 70, 0, 30);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.cible();
        adversaire.damage(getAtk());
    }
}