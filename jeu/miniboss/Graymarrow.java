package jeu.miniboss;

import jeu.combattants.Combattant;
import jeu.gestions.Equipe;

public class Graymarrow extends Combattant{
    public Graymarrow() {
        super(800, 45, 20, 30, 3000);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        adversaire.prendreDegat(this);
        System.out.println(getNom() + "[id : "+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

    @Override
    public String toString() {
        return "Greymarrow ["+getPV()+" / 1000]";
    }

    @Override
    public String getNom() {
        return "Greymarrow";
    } 
}
