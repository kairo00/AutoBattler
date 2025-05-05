package jeu.combattants;

import jeu.gestions.Equipe;

public class Abomination extends Combattant {

    public Abomination() {
        super(200, 30, 20, 20, 50);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        regenererPV(2);
        if(getMadness() > 0) {
            adversaire.prendreDegat(this);
        }
        if(getMadness() > -10) {
            adversaire.prendreDegat(this);
            adversaire.prendreDegat(this);
        }else{
            if(getMadness() > -20) {
                adversaire.prendreDegat(this);
                adversaire.prendreDegat(this);
            }else{
                if(getMadness() > -30) {
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