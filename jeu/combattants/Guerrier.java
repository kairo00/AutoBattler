package jeu.combattants;
/**
 * Classe Guerrier qui hérite de Combattant
 * Elle gère les capacités spéciales du combattant Guerrier.
 * Capacité spéciale: Lorsqu’il reçoit des dégâts et survit, le guerrier à 60% de chance d’attaquer son assaillant
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 * @see Combattant
 */
public class Guerrier extends Combattant{
    
    /**
     * 
     */
    public Guerrier() {
        super(220, 30, 25, 20);
    }

    /**
     * 
     */
    @Override
    public void activerPassive(Combattant cible) {
        int r = (int)(Math.random()*10);
        if(r < 6) {
            cible.prendreDegat(this);
        }
        /* System.out.println(cible.getNom()+" perds "+(getAtk()-cible.getDef())+" pv:"+cible.getPV()+"/220"); */
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "G["+getPV()+"/"+getPvMax()+"]";
    }

    /**
     * 
     */
    @Override
    public String getNom() {
        return "Guerrier";
    }
}
