package jeu.combattants;
import jeu.gestions.Equipe;

public class Berserker extends Combattant{
   
    public Berserker() {
        super(220, 55, 10, 50, 120);
    }

    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);

        System.out.println("["+getId() + "]"+getNom() + " attaque " +"["+adversaire.getId()+"]"+adversaire.getNom()+ " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
        if(getPV() <= 80 && estEnVie()) {
            adversaire = ennemis.choisirCombattantAleatoire();
            adversaire.prendreDegat(this);
            System.out.println("Attaque suplémentaire du Berserker !");
        }
    }

    @Override
    public String toString() {
        return "B["+getPV()+"/220]";
    }

    @Override
    public String getNom() {
        return "Berseker";
    }
}