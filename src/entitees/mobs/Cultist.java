package src.entitees.mobs;
import src.entitees.Combattant;

public class Cultist extends Combattant {

    //Monstre du mode alternatif
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