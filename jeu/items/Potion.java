package jeu.items;
import jeu.combattants.Combattant;
import jeu.gestions.Equipe;

public class Potion extends Item {

    private final int ajoutePv = 40;
    public Potion() {
        super("Potion", "Consummable", 50);
    }

    @Override
    public void effet(Equipe equipe) {
        for(Combattant i: equipe.getEquipe()) {
            i.regenererPV(ajoutePv);
            System.out.println("Vous avez utilisé une potion, vos unités régénere "+ajoutePv+" pv !");
        }
    }

    @Override
    public String toString() {
        return "Potion";
    }
}