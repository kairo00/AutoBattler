package src.jeu.comparateurs;
import java.util.Comparator;

import src.entitees.Combattant;

/**
 * Comparateur de combattants selon leur PV décroissant.
 * Retourne un nombre négatif si o1 a plus de PV que o2.
 */
public class ComparatorVie implements Comparator<Combattant> {
    
    /**
     * Compare deux personnages selon leur PV.
     * @param o1 le premier combattant
     * @param o2 le deuxième combattant
     * @return un nombre positif si o2 a plus de PV, négatif si o1 a plus de PV, 0 si égal
     */
    @Override
    public int compare(Combattant o1, Combattant o2) {
        if(o1.getPV() < o2.getPV()) return 1;
        if(o1.getPV() > o2.getPV()) return -1;
        return 0;
    }
}