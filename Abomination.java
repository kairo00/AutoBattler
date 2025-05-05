public class Abomination extends Combattant {

    Abomination() {
        super(200, 30, 20, 20, 50);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        regenererPV(2);
        if(getMadness() > 0) {
            adversaire.damage(this);
        }
        if(getMadness() > -10) {
            adversaire.damage(this);
            adversaire.damage(this);
        }else{
            if(getMadness() > -20) {
                adversaire.damage(this);
                adversaire.damage(this);
            }else{
                if(getMadness() > -30) {
                    adversaire.damage(this);
                    adversaire.damage(this);
                    adversaire.damage(this);
                    adversaire.damage(this);
                }
            
            }
        }
    }   

    @Override
    public String getNom() {
        return "Abomination";
    }

    @Override
    public String toString() {
        return "Ab["+getPV()+"/200]";
    }
}