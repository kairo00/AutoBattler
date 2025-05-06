package jeu.combattants;
import jeu.gestions.Equipe;

public abstract class Combattant {

    private final int pvMax;
    private int pv;
    private int courage;
    private final int attaque;
    private final int defense;
    private final int vitesse;
    private int fuite = 0;
    public static int id;
    private Combattant cible;

    public Combattant(int pvMax, int attaque, int defense, int vitesse, int courage){
        this.pv = pvMax;
        this.pvMax = pvMax;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        id++;
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
    }

    public void prendreDegat(Combattant attaquant) {
        int r = (int)(3*Math.random());
        if (activerEsquive() || (attaquant.getAttaque() <= getDefense())) {
            return;
        }
        int degat = attaquant.calculerDegat(cible);
        soustraireCourage(5);
        if(r == 1) {
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

    public boolean activerEsquive() {
        int r = (int)(21*Math.random());
        return r == 1;
    }

    public void soin(Equipe cible) {
    }

    public boolean estEnVie(){
        return (fuite < 1 && pv > 0);
    }

    public int getPVMax() {
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
        return id;
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
