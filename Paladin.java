
public class Paladin extends Combattant {
    Paladin() {
        super(200, 45, 25, 10);
    }

    @Override
    public void passive(Combattant cible) {
        int pv = getPV();
        if(pv <= 190) {
            regenererPV(10);
        }
        if(pv > 190) {
            regenererPV(200-pv);
        }
    }

    @Override
    void attack(Equipe ennemis) {
        super.attack(ennemis);
    }

    @Override
    public String toString() {
        return "P["+getPV()+"/200]";
    }

    public String getNom() {
        return "Paladin";
    }
}
