package src.entitees.mobs;
import src.entitees.Combattant;

/**
 * Classe représentant un diablotin.
 * Diablotin: mob du mode alternatif (impossible d'etre joué par un joueur)
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Demon extends Combattant{

    /**
     * Cree un demon
     */
    public Demon() {
        super(150, 40, 20, 35, 200);
    }
    
    @Override
    public String getNom() {
        return "Demon";
    }

    @Override
    public String toString() {
        return "D["+getPV()+"/"+getPvMax()+"]";
    }
    
}