public class Cultist extends Combattant {

    public Cultist() {
        super(100, 10, 10, 30, 70);
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