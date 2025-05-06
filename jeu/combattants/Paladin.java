package jeu.combattants;

import jeu.gestions.Equipe;

/**
 * Classe Paladin qui hérite de Combattant
 * Elle gère les capacités spéciales du combattant Paladin.
 * Capacité spéciale: Se régénere de 10pv dès que c'est sont tour (ne dépasse jamais les 200pv max)
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 * @see Combattant
 */
public class Paladin extends Combattant {
    
    /**
     * 
     */
    public Paladin() {
        super(200, 45, 25, 10, 100);
    }

    /**
     * 
     */
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
        System.out.println(getNom() + "[Equipe " + getId() + "] a attaqué " + adversaire.getNom() + "[Equipe " + ennemis.getID() + "] et lui a infligé " + getAttaque() + " dégâts.");
        System.out.println(">>> PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax() + " | Courage : " + adversaire.getCourage());
        System.out.println(">>> PV attaquant : " + getPV() + "/" + getPvMax() + " | Courage : " + getCourage());
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "P["+getPV()+"/"+getPvMax()+"]";
    }

    /**
     * 
     */
    @Override
    public String getNom() {
        return "Paladin";
    }
}
