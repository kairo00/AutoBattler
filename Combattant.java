public abstract class Combattant {

    static int compteur = 20;
    private int pv;
    private int attaque;
    private int defense;
    private int vitesse;
    private int id;
    private Combattant cible;
  
    public static int cpt = 0;

    Combattant(int pv, int attaque, int defense, int vitesse){
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        cpt++;
    }

    public void cible(Equipe equipe) {
        cible =  equipe.choisirCombattantAleatoire();
    }

    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.damage(getAtk() - adversaire.getDef(), this);

        if(getAtk() < adversaire.getDef()) {
            adversaire.damage(0, this);
        }
    }

    void damage(int damage, Combattant attaquant) {

        if (esquive()) {
            damage = 0;
        }
        pv -= damage;
        cible = attaquant;
        passive(cible);
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

    public void passive(Combattant cible) {
    }

    public boolean isAlive(){
        if(pv <= 0) {
            return false;
        }
        return true;
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

    Combattant getCible() {
        return cible;
    }
  
    public abstract String getNom();

}
