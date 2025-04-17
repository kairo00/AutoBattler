
public class Guerrier extends Combattant{
    Guerrier() {
        super(220, 30, 25, 20);
    }

    public void passive(Combattant cible) {
        int r = (int)(6*Math.random());
        if(r != 4 || r != 5) {
            cible.damage(getAtk() - cible.getDef(), this);

            if(getAtk() < cible.getDef()) {
                cible.damage(0, this);
            }
        }
    }
}
