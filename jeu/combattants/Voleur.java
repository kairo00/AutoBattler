package jeu.combattants;

/**
 * Classe Voleur qui hérite de Combattant
 * Elle gère les capacités spéciales du combattant Voleur.
 * Capacité spéciale: Lorsqu’il est ciblé par une attaque (non magique), le voleur a 50% de chance d’esquiver.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 * @see Combattant
 */
public class Voleur extends Combattant{
    
    /**
     * 
     */
    public Voleur() {
        super(145, 45, 20, 40);
    }

    /**
     * 
     */
    @Override
    public boolean activerEsquive() {
        int r = (int)(2*Math.random());

        if(r == 1) {
            return true;
        }
        return false;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "V["+getPV()+"/145]";
    }

    /**
     * 
     */
    @Override
    public String getNom() {
        return "Voleur";
    }
}
