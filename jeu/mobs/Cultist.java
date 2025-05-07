package jeu.mobs;
import jeu.combattants.Combattant;

public class Cultist extends Combattant {

    public Cultist() {
        super(100, 10, 10, 30, 150);
    }

    @Override
    public String toString() {
        return "C["+getPV()+"/220]";
    }

    @Override
    public String getNom() {
        return "Cultist";
    }
}