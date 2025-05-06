public abstract class Combattant {

    private final int pvMax;
    private int pv;
    private int peur;
    private final int attaque;
    private final int defense;
    private final int vitesse;
    private int fuite = 0;
    private int id;
    private Combattant cible;
  
    public static int cpt = 0;

    Combattant(int pv, int attaque, int defense, int vitesse, int peur){
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        pvMax = pv;
        cpt++;
    }

    public void cibleAdverse(Equipe equipe) {
        cible =  equipe.choisirCombattantAleatoire();
    }

    public void action(Equipe ennemie, Equipe alliée) {
        attack(ennemie);
    }

    void attack(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.damage(this);
    }

    void damage(Combattant attaquant) {
        int r = (int)(3*Math.random());
        if (esquive() || (attaquant.getAtk() <= getDef())) {
            return;
        }
        int degat = attaquant.Degat(this);
        soustrairePeur(10);
        if(r == 1) {
            fuite++;
        }
        if(degat > 0) pv = Math.max(0, pv - degat);


    }

    public int Degat(Combattant cible) {
        return getAtk() - cible.getDef();
    }

    public void regenererPV(int pv) {
        if(isAlive())this.pv += pv;
    }

    public void regenererPeur(int peur){
        if(isAlive())this.peur += peur;
    }
    
    public void soustrairePeur(int peur) {
         if(isAlive())this.peur -= peur;
    }

    public boolean esquive() {
        int r = (int)(21*Math.random());
        return r == 1;
    }

    public void soin(Equipe cible) {
    }

    public boolean isAlive(){
        return (fuite < 1 && pv > 0);
    }

    int getPVMax() {
        return pvMax;
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

    int getPeur() {
        return peur;
    }
    
    Combattant getCible() {
        return cible;
    }
  
    public abstract String getNom();
    public abstract String toString();

}
