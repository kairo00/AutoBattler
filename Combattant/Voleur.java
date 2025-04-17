public class Voleur extends Combattant{
    Voleur() {
        super(145, 45, 20, 40);
    }

    @Override
    public boolean esquive() {
        int r = (int)(2*Math.random());

        if(r == 1) {
            return true;
        }
        return false;
    }
}
