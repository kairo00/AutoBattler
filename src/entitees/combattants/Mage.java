package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Mage extends Combattant {

    public Mage() {
        super(160, 70, 0, 30, 80);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        System.out.println(adversaire.getPV());
        adversaire.prendreDegat(this);
        System.out.println(adversaire.getNom()+" degat subit: "+getAttaque()+" pv: "+adversaire.getPV()+"/200");
    }

    @Override
    public int calculerDegat(Combattant cible) {
        return getAttaque();
    }

    @Override
    public String toString() {
        return "M["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Mage";
    }
}