package jeu.boss;

import jeu.combattants.Combattant;
import jeu.gestions.Equipe;
public class Monika extends Combattant {

    public Monika() {
        super(1600, 45, 20, 30, 3000);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        adversaire.prendreDegat(this);
        adversaire.prendreDegat(this);
        adversaire.prendreDegat(this);
        System.out.println(getNom() + "[id : "+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

    @Override
    public String toString() {
        return "Monika ["+getPV()+" / 1600]";
    }

    @Override
    public String getNom() {
        return "Monika";
    } 
    
    
}
