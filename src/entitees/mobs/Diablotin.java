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
public class Diablotin extends Combattant{

    /**
     * Cree un diablotin
     */
    public Diablotin() {
        super(50, 20, 5, 60 , 100);
    }
    
    @Override
    public String getNom() {
        return "Diablotin";
    }

    @Override
    public String toString() {
        return "Dia["+getPV()+"/"+getPvMax()+"]";
    }
}