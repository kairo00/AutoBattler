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
        }
        if(getPV() > 190) {
            regenererPV(200-getPV());
        }
        System.out.println("["+getId() + "]"+getNom() + " attaque " +"["+adversaire.getId()+"]"+adversaire.getNom()+ " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
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
