package jeu.combattants;
import jeu.gestions.Equipe;

public class Abomination extends Combattant {

    public Abomination() {
        super(200, 30, 20, 20, 80);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        regenererPV(5);
        if(getCourage() > 0) {
            adversaire.prendreDegat(this);
        }
        if(getCourage() > -10) {
            adversaire.prendreDegat(this);
            adversaire.prendreDegat(this);
        }else{
            if(getCourage() > -20) {
                adversaire.prendreDegat(this);
                adversaire.prendreDegat(this);
            }else{
                if(getCourage() > -30) {
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
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