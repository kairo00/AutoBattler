package src.items;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Biere extends Item{

    final int regenerePeur = 50;

    public Biere() {
        super("Biere", "Consumable", 50);
    }
    
    @Override
    public void effet(Equipe equipe) {
        for(Combattant c : equipe.getEquipe()) {
            c.regenererCourage(regenerePeur);
            System.out.println("Vous avez utilisé une bière, vos unités régénere "+regenerePeur+" de courage !");
        }
    }

    @Override
    public String toString() {
        return "Biere";
    }
}