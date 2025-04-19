
public class Guerrier extends Combattant{
    
    Guerrier() {
        super(220, 30, 25, 20);
    }

    @Override
    public void passive(Combattant cible) {
        int r = (int)(Math.random()*10);
        if(r < 6) {
            cible.damage(this);
        }
        System.out.println(cible.getNom()+" perds "+(getAtk()-cible.getDef())+" pv:"+cible.getPV()+"/220");
    }

    @Override
    public String toString() {
        return "G["+getPV()+"/220]";
    }

    public String getNom() {
        return "Guerrier";
    }
}
