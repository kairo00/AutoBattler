package jeu.combattants;
import jeu.gestions.Equipe;

public class Paladin extends Combattant {
    public Paladin() {
        super(200, 45, 25, 10, 110);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);

        if(getPV() <= 190) {
            regenererPV(10);
            System.out.println("+10pv (<= 190) pour le paladin");
        }
        if(getPV() > 190) {
            regenererPV(200-getPV());
        }
        System.out.println(getNom() + "[Equipe " + getId() + "] a attaqué " + adversaire.getNom() + "[Equipe " + ennemis.getID() + "] et lui a infligé " + getAttaque() + " dégâts.");
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "P["+getPV()+"/200]";
    }

    @Override
    public String getNom() {
        return "Paladin";
    }
}
