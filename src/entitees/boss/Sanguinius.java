package src.entitees.boss;

import src.entitees.Combattant;
import src.jeu.gestions.*;

public class Sanguinius extends Combattant{
    public Sanguinius() {
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
        return "Tiamat["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Tiamat";
    } 
    
    
}
