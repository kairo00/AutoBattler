package src.items;

import src.jeu.gestions.*;

public class PorteurdeCendre extends Item{

    /**
     * Création de l'objet PorteurdeCendre
     */
    public PorteurdeCendre() {
        super("PorteurdeCendre", "Equipement", 250, 125);
    }

    /**
     * L'épée renvoie du texte
     * @param equipe qui bénéfira de l'effet
     */
    @Override
    public void effet(Equipe equipe) {
        System.out.print("On a pas le droit aux setters donc j'peux pas buff les persos avec des equipements tristesse desespoir je plore");
    }
    
}
