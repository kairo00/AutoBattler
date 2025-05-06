package jeu.combattants;

public class Voleur extends Combattant{
    public Voleur() {
        super(145, 45, 20, 40,100);
    }

    @Override
    public boolean activerEsquive() {
        int r = (int)(2*Math.random());

        return r == 1;
    }

    @Override
    public String toString() {
        return "V["+getPV()+"/145]";
    }

    @Override
    public String getNom() {
        return "Voleur";
    }
}
