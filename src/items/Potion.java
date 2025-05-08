package src.items;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Potion extends Item {

    private final int ajoutePv = 40;
    public Potion() {
        super("Potion", "Consummable", 50);
    }

    @Override
    public void effet(Equipe equipe) {
        for(Combattant i: equipe.getEquipe()) {
            if(i.estEnVie())i.regenererPV(ajoutePv);
            System.out.println("Vous avez utilisé une potion, "+i.getNom()+" recoit "+ajoutePv+" pv !");
        }
    }

    @Override
    public String toString() {
        return "Potion";
    }
}