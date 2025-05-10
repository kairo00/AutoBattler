package src.items;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représentant une bière.
 * Biere: objet consommable qui régénère le courage des combattants d'une équipe.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Item
 */
public class Biere extends Item{

    private final int regenereCourage = 50;

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
        for(Combattant c : equipe.getEquipe()) {
            c.regenererCourage(regenereCourage);
            System.out.println("Vous avez utilisé une bière, vos unités régénere "+regenereCourage+" de courage !");
        }
    }

    /**
     * toString de l'item bière
     * @return le nom de l'objet
     */
    @Override
    public String toString() {
        return "Biere";
    }
}