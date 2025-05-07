package jeu.mobs;
import jeu.combattants.Combattant;

public class Diablotin extends Combattant{

    public Diablotin() {
        super(50, 20, 5, 60 , 100);
    }
    
    @Override
    public String getNom() {
        return "Diablotin";
    }

    @Override
    public String toString() {
        return "Dia["+getPV()+"/200]";
    }
}