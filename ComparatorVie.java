import java.util.Comparator;

public class ComparatorVie implements Comparator<Combattant> {
    
    @Override
    public int compare(Combattant o1, Combattant o2) {
        if(o1.getPV() < o2.getPV()) return -1; //o1 inferieur a o2.
        if(o1.getPV() > o2.getPV()) return 1; //o1 superieur a o2.
        return 0; //o1 et o2 sont egaux.
    }
}
