package src.items;

import src.jeu.gestions.*;

/**
 * Classe représentant l'item These.
 * These: objet consommable mysterieux...
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Item
 */
public class These extends Item{

    /**
     * Création de l'objet These
     */
    public These() {
        super("These", "Consommable", 50, 25);
    }

    /**
     * La thèse renvoie du texte
     * @param equipe qui bénéfira de l'effet
     */
    @Override
    public void effet(Equipe equipe) {
        System.out.println("Titre : Validation de composants d'intelligence artificielle issus d'apprentissages sur la base de détection d'aberration et de tests métamorphiques");
        System.out.println("* Vous ne possedez pas assez de points intelligence pour déchiffrer la suite de ce texte *");
    }

    @Override
    public String toString() {
        return "These d'un autre monde";
    }


    
}
