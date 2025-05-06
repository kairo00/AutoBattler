package jeu.mobs;
import jeu.combattants.Combattant;

public class Demon extends Combattant{

    public Demon() {
        super(1, 1, 1, 1, 1);
    }
    
    @Override
    public String getNom() {
        return "Demon";
    }

    @Override
    public String toString() {
        return "D["+getPV()+"/200]";
    }
    
}