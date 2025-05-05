public class Diablotin extends Combattant{

    public Diablotin() {
        super(1, 1, 1, 1, 1);
    }
    
    @Override
    public String getNom() {
        return "Abomination";
    }

    @Override
    public String toString() {
        return "Ab["+getPV()+"/200]";
    }
}