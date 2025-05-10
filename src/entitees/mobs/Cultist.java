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
public class Cultist extends Combattant {

    /**
     * Cree un cultist
     */
    public Cultist() {
        super(100, 10, 10, 30, 150);
    }

    @Override
    public String toString() {
        return "C["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Cultist";
    }
}