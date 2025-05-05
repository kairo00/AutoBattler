

public class Berserker extends Combattant{
   
    Berserker() {
        super(220, 55, 10, 50, 80);
    }

    @Override
    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.damage(this);

        if(getPV() <= 80 && isAlive()) {
            adversaire = ennemis.choisirCombattantAleatoire();
            adversaire.damage(this);
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