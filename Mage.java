

public class Mage extends Combattant {

    Mage() {
        super(160, 70, 0, 30, 80);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        System.out.println(adversaire.getPV());
        adversaire.damage(this);
        System.out.println(adversaire.getNom()+" degat subit: "+getAtk()+" pv: "+adversaire.getPV()+"/200");
    }

    @Override
    public int Degat(Combattant cible) {
        return getAtk();
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