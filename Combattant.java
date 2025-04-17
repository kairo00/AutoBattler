

public abstract class Combattant {
    static int compteur = 20;
    private int pv;
    private int attaque;
    private int defense;
    private int vitesse;
    private int id;

    Combattant(int pv, int attaque, int defense, int vitesse){
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
    }


    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.cible();
        adversaire.damage(getAtk() - adversaire.getDef());

        if(getAtk() < adversaire.getDef()) {
            adversaire.damage(0);
        }
    }

    void damage(int damage) {
        if (esquive()) {
            damage = 0;
        }
        pv -= damage;
        passive();
    }

    public void regenererPV(int pv) {
        this.pv += pv;
    }

    public boolean esquive() {
        int r = (int)(21*Math.random());
        if(r == 1) {
            return true;
        }
        return false;
    }

    public void passive() {

    }
    




    public String toString(){
        return "Combattant";
    }

    int getPV() {
        return pv;
    }

    int getAtk() {
        return attaque;
    }

    int getDef() {
        return defense;
    }

    int getVit() {
        return vitesse;
    }

    int getId() {
        return id;
    }
}
