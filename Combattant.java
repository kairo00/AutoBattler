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

    void capaciteSpeciale() {
    }

    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.cible();
        adversaire.damage();
    }

    void damage(int attaque) {
        pv -= attaque - defense;
    }

    void target(Combattant Adversaire){

    }

    void regenererPV(int pv) {
        this.pv = pv;
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
