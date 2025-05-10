package src.entitees.mobs;
import src.entitees.Combattant;

public class Diablotin extends Combattant{

    //Monstre du mode alternatif
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