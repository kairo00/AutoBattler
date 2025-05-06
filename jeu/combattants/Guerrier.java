package jeu.combattants;

public class Guerrier extends Combattant{
    
    public Guerrier() {
        super(220, 30, 25, 20, 110);
    }

    @Override
    public void prendreDegat(Combattant cible) {
        int r = (int)(Math.random()*10);
        super.prendreDegat(cible);
        if(r < 6) {
            cible.prendreDegat(this);
            System.out.println("BOOM CONTRE ATTAQUE");
        }
    }

    @Override
    public String toString() {
        return "G["+getPV()+"/220]";
    }

    @Override
    public String getNom() {
        return "Guerrier";
    }
}
