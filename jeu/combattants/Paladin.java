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
        super(200, 45, 25, 10);
    }

    /**
     * 
     */
    @Override
    public void activerPassive(Combattant cible) {
        int pv = getPV();
        if(pv <= 190) {
            regenererPV(10);
        }
        if(pv > 190) {
            regenererPV(200-pv);
        }
    }

    /**
     * 
     */
    @Override
    public void attaquer(Equipe ennemis) {
        super.attaquer(ennemis);
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
