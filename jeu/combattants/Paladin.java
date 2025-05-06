package jeu.combattants;
import jeu.gestions.Equipe;

public class Paladin extends Combattant {
    public Paladin() {
        super(200, 45, 25, 10, 110);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        int pv= getPV();
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        
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
