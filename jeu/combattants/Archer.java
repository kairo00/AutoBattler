package jeu.combattants;

import jeu.gestions.Equipe;

/**
 * Classe Archer qui hérite de Combattant
 * Elle gère les capacités spéciales du combattant Archer.
 * Capacité spéciale: Les attaques de l’archer ciblent toujours le combattant adverse qui a le moins de PV
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 * @see Combattant
 */
public class Archer extends Combattant {

    /**
     * Crée
     */
    public Archer() {
        super(170, 55, 5, 60);
    }

    /**
     * 
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantFaible();
        adversaire.prendreDegat(this);
        System.out.println(adversaire.getNom()+"[Equipe "+ennemis.getID()+"] "+" a subit une attaque de "+getNom()+"lui infligeant "+getAttaque()+"de dégats || pv: "+adversaire.getPV()+"/"+adversaire.getPvMax());
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "A["+getPV()+"/"+getPvMax()+"]";
    }

    /**
     * 
     */
    @Override
    public String getNom() {
        return "Archer";
    }
}
