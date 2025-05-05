package jeu.combattants;

import jeu.gestions.Equipe;

/**
 * Classe Mage qui hérite de Combattant
 * Elle gère les capacités spéciales du combattant Mage.
 * Capacité spéciale: Les attaques du mage ne sont pas réduites par la défense adverse et ne peuvent pas être esquivées
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 * @see Combattant
 */
public class Mage extends Combattant {

    /**
     * 
     */
    public Mage() {
        super(160, 70, 0, 30, 120);
    }

    /**
     * 
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        System.out.println(adversaire.getPV());
        adversaire.prendreDegat(this);
        System.out.println(adversaire.getNom()+"[Equipe "+ennemis.getID()+"] "+" a subit une attaque de "+getNom()+"lui infligeant "+getAttaque()+"de dégats || pv: "+adversaire.getPV()+"/"+adversaire.getPvMax());
    }

    /**
     * 
     */
    @Override
    public int calculerDegat(Combattant cible) {
        return getAttaque();
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "M["+getPV()+"/"+getPvMax()+"]";
    }

    /**
     * 
     */
    @Override
    public String getNom() {
        return "Mage";
    }
}