package jeu.combattants;
import jeu.gestions.Equipe;

public abstract class Combattant {

    private final int pvMax;
    private int pv;
    private final int courageMax;
    private int courage;
    private final int attaque;
    private final int defense;
    private final int vitesse;
    private int fuite = 0;
    private final int idPerso;
    public static int id = 0;
    private Combattant cible;

    public Combattant(int pvMax, int attaque, int defense, int vitesse, int courage){
        this.pv = pvMax;
        this.pvMax = pvMax;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.courage = courage;
        this.courageMax = courage;
        idPerso = id++;
    }

    public void cibleAdverse(Equipe equipe) {
        cible =  equipe.choisirCombattantAleatoire();
    }

    public void action(Equipe ennemie, Equipe alliée) {
        attaquer(ennemie);
    }

    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        System.out.println("["+getId() + "]"+getNom() + " attaque " +"["+adversaire.getId()+"]"+adversaire.getNom()+ " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

    public void prendreDegat(Combattant attaquant) {
        int r = (int)(3*Math.random());
        if (activerEsquive() || (attaquant.getAttaque() <= getDefense())) {
            return;
        }
        int degat = attaquant.calculerDegat(this);
        soustraireCourage(10);
        if(courage==0 && r == 1) {
            fuite++;
        }
        if(degat > 0) pv = Math.max(0, pv - degat);
    }

    public int calculerDegat(Combattant cible) {
        return getAttaque() - cible.getDefense();
    }

    public void regenererPV(int pv) {
        if(estEnVie())this.pv += pv;
    }

    public void regenererCourage(int courage){
        if(estEnVie())this.courage += courage;
    }
    
    public void soustraireCourage(int courage) {
         if(estEnVie())this.courage -= courage;
    }

    /**
     * 
     * @return
     */
    public boolean activerEsquive() {
        int r = (int)(21*Math.random());
        if(r == 1) {
            System.out.println("Le "+getNom()+" esquive !");
            return true;
        }
        return false;
    }

    public void soin(Equipe cible) {
    }

    /**
     * 
     * @return
     */
    public boolean estEnVie(){
        return (fuite < 1 && pv > 0);
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getPV() {
        return pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getId() {
        return idPerso;
    }

    public int getCourageMax() {
        return courageMax;
    }
    
    public int getCourage() {
        return courage;
    }
    
    public Combattant getCible() {
        return cible;
    }

    public abstract String getNom();
    @Override
    public abstract String toString();

}
