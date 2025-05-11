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
     * @param ennemie que le mini-boss va attaquer
     */
    @Override
    public void attaquer(Equipe ennemie, Equipe alliee) {
        Combattant adversaire = ennemie.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        adversaire.prendreDegat(this);
         System.out.println("🗡️ [Mini Boss] " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
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
