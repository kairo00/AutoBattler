package src.entitees.miniboss;

import src.entitees.*;
import src.jeu.gestions.*;

/**
 * Classe représentant le miniboss Herald.
 * Herald est un miniboss du mode alternatif (impossible d'etre joué par un joueur)
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Herald extends Combattant{
    /**
     * Cree un Herald
     */
    public Herald() {
        super(800, 45, 20, 30, 3000);
    }

    /**
     * Les mini-boss attaquent 2 fois
     * @param ennemis que le mini-boss va attaquer
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        adversaire.prendreDegat(this);
        System.out.println(getNom() + "[id : "+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

        @Override
    public String toString() {
        return "Herald ["+getPV()+" /"+getPvMax()+"]";
    }
    
    @Override
    public String getNom() {
        return "Herald";
    } 
}
