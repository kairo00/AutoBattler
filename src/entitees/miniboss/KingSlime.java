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
public class KingSlime extends Combattant{

    /**
     * Cree un KingSlime
     */
    public KingSlime() {
        super(1000, 30, 20, 20, 3000);
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
        return "King Slime ["+getPV()+" /"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "King Slime";
    } 
}
