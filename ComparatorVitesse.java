import java.util.Comparator;

public class ComparatorVitesse implements Comparator<Combattant> {

    /*
     * Prends deux combattants à comparer en paramètre
     * 
     */

    @Override
    public int compare(Combattant o1, Combattant o2) {
        if(o1.getVit() < o2.getVit()) return -1; //o1 inferieur a o2.
        if(o1.getVit() > o2.getVit()) return 1; //o1 superieur a o2.
        return 0; // o1 et o2 sont egaux.
    }
    
}