package src.jeu.comparateurs;
import java.util.Comparator;

import src.entitees.Combattant;

/**
 * Comparateur de combattants selon leur vitesse décroissant.
 * Retourne un nombre négatif si o1 est plus rapide que o2.
 */
public class ComparatorVitesse implements Comparator<Combattant> {

    /**
     * Compare deux personnages selon leur vitesse.
     * @param o1 le premier combattant
     * @param o2 le deuxième combattant
     * @return un nombre positif si o2 es plus rapide, négatif si o1 est plus rapide, 0 si égal
     */
    @Override
    public int compare(Combattant o1, Combattant o2) {
        if(o1.getVitesse() < o2.getVitesse()) return 1;
        if(o1.getVitesse() > o2.getVitesse()) return -1; 
        return 0;
    }
    
}