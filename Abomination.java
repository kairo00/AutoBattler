public class Abomination extends Combattant {

    Abomination() {
        super(200, 30, 20, 20, 80);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        regenererPV(5);
        if(getPeur() > 0) {
            adversaire.damage(this);
        }
        if(getPeur() > -10) {
            adversaire.damage(this);
            adversaire.damage(this);
        }else{
            if(getPeur() > -20) {
                adversaire.damage(this);
                adversaire.damage(this);
            }else{
                if(getPeur() > -30) {
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