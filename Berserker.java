public class Berserker extends Combattant{
   
    Berserker() {
        super(220, 55, 10, 50);
    }

    @Override
    void attack(Equipe ennemis) {
        int pv = getPV();
        Combattant adversaire = ennemis.cible();
        adversaire.damage(getAtk() - adversaire.getDef());

        if(getAtk() < adversaire.getDef()) {
            adversaire.damage(0);
        }

        if(pv <= 80) {
            attack(ennemis);
        }
    }
}