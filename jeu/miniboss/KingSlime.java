package jeu.miniboss;


import jeu.combattants.Combattant;
import jeu.gestions.Equipe;

public class KingSlime extends Combattant{
    public KingSlime() {
        super(1000, 30, 20, 20, 3000);
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
        return "King Slime ["+getPV()+" / 1000]";
    }

    @Override
    public String getNom() {
        return "King Slime";
    } 
}
