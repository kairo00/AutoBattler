package jeu.combattants;
import jeu.gestions.Equipe;

public class Mage extends Combattant {

    public Mage() {
        super(160, 70, 0, 30, 80);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        System.out.println(adversaire.getPV());
        adversaire.prendreDegat(this);
        System.out.println("["+getId() + "]"+getNom() + " attaque " +"["+adversaire.getId()+"]"+adversaire.getNom()+ " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

    @Override
    public int calculerDegat(Combattant cible) {
        return getAttaque();
    }

    @Override
    public String toString() {
        return "M["+getPV()+"/160]";
    }

    @Override
    public String getNom() {
        return "Mage";
    }
}