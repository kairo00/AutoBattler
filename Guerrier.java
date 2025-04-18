
public class Guerrier extends Combattant{
    
    Guerrier() {
        super(220, 30, 25, 20);
    }

    public void passive(Combattant cible) {
        int r = (int)(Math.random()*10);
        if(r < 6) {
            cible.damage(getAtk() - cible.getDef(), this);

            if(getAtk() < cible.getDef()) {
                cible.damage(0, this);
            }
        }
    }

    @Override
    public String toString() {
        return "G["+getPV()+"/220]";
    }

    public String getNom() {
        return "Guerrier";
    }
}
