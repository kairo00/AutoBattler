package jeu.mobs;
import jeu.combattants.Combattant;

public class Demon extends Combattant{

    public Demon() {
        super(150, 40, 20, 35, 200);
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