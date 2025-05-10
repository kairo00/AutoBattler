package src.items;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Potion extends Item {

    //Nombre de pv que la potion va rénégéner
    private final int ajoutePv = 40;

    /**
     * Création de l'objet potion
     */
    public Potion() {
        super("Potion", "Consummable", 50, 25);
    }

    /**
     * La potion redonne à tout les combattans 50 de vie
     * @param equipe qui bénéfira de l'effet
     */
    @Override
    public void effet(Equipe equipe) {
        //Régènere la vie de toute l'équipe
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