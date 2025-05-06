
public class Guerrier extends Combattant{
    
    Guerrier() {
        super(220, 30, 25, 20, 110);
    }

    @Override
    public void damage(Combattant cible) {
        int r = (int)(Math.random()*10);
        super.damage(cible);
        if(r < 6) {
            cible.damage(this);
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
