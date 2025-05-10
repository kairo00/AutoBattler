package src.items;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Biere extends Item{

    final int regenerePeur = 50;

    /**
     * Création de l'objet bière
     */
    public Biere() {
        super("Biere", "Consumable", 50, 25);
    }
    
    /**
     * La bière redonne à tout les combattans 50 de courage
     * @param equipe qui bénéfira de l'effet
     */
    @Override
    public void effet(Equipe equipe) {
        //Régénère le courage de tous les combattants.
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