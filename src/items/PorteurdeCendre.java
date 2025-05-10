package src.items;

import src.jeu.gestions.*;

/**
 * Classe représentant l'objet PorteurdeCendre
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Item
 */
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
