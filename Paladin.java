
public class Paladin extends Combattant {
    Paladin() {
        super(200, 45, 25, 10, 100);
    }

    @Override
    void attack(Equipe ennemis) {
        int pv= getPV();
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.damage(this);
        
        if(pv <= 190) {
            regenererPV(10);
        }
        if(pv > 190) {
            regenererPV(200-pv);
        }
    }

    @Override
    public String toString() {
        return "P["+getPV()+"/200]";
    }

    @Override
    public String getNom() {
        return "Paladin";
    }
}
