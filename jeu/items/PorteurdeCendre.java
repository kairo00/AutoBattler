package jeu.items;

import jeu.gestions.Equipe;

public class PorteurdeCendre extends Item{

    public PorteurdeCendre() {
        super("PorteurdeCendre", "Equipement", 250);
    }

    @Override
    public void effet(Equipe equipe) {
        System.out.print("On a pas le droit au setter donc j'peux pas buff les persos avec des equipements tristesse desespoir je plore");
    }
    
}
