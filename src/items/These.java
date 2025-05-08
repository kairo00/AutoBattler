package src.items;

import src.jeu.gestions.*;

public class These extends Item{

    public These() {
        super("These d'un autre monde", "Consommable", 50);
    }

    @Override
    public void effet(Equipe equipe) {
        System.out.println("Titre : Validation de composants d'intelligence artificielle issus d'apprentissages sur la base de détection d'aberration et de tests métamorphiques");
        System.out.println("* Vous ne possedez pas assez de points intelligence pour déchiffrer la suite de ce texte *");
    }


    
}
