package jeu.combattants;

import jeu.gestions.Equipe;

/**
 * Cette classe représente un combattant.
 * La classe Combattant permet de gérer les attaques des différents combattants, les dégats subits ou envoyés ainsi que les attaques dites "activerPassives".
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public abstract class Combattant {
    private int pv;
    private int pvMax;
    private int courage;
    private int attaque;
    private int defense;
    private int vitesse;
    private int fuite = 0;
    private int id;
    private Combattant cible;
  
    public static int cpt = 0;

    /**
     * 
     * @param pvMax définit les pv maximum du combattant
     * @param attaque définit la puissance de l'attaque du combattant
     * @param defense définit la puissance de la défense du combattant
     * @param vitesse définit la vitesse du combattant
     */
    public Combattant(int pvMax, int attaque, int defense, int vitesse, int madness){
        this.pv = pvMax;
        this.pvMax = pvMax;
        this.courage = madness;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        cpt++;
    }

    /**
     * 
     */
    public void cibleAdverse(Equipe equipe) {
        cible =  equipe.choisirCombattantAleatoire();
    }

    public void action(Equipe ennemie, Equipe alliée) {
        attaquer(ennemie);
    }

    /**
     * 
     * @param ennemis
     */
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        if(adversaire == null || !adversaire.estEnVie()) return;
        adversaire.prendreDegat(this);
        System.out.println(adversaire.getNom() + "[Equipe " + ennemis.getID() + "] a subit une attaque de " + getNom() + " lui infligeant " + getAttaque() + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax() + "  " + adversaire.getCourage());
    }

    /**
     * 
     * @param attaquant
     */
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

    /**
     * 
     * @param cible
     * @return
     */
    public int calculerDegat(Combattant cible) {
        return getAttaque() - cible.getDefense();
    }

    /**
     * 
     * @param pv
     */
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
            System.out.println("ESQUIVERRRR");
            return true;
        }
        System.out.println("Pas esquiver...");
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

    /**
     * 
     */
    @Override
    public abstract String toString();

    public int getPV() {
        return pv;
    }

    public int getPvMax() {
        return pvMax;
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

    Combattant getCible() {
        return cible;
    }

    public int getCourage() {
        return courage;
    }

    public abstract String getNom();

}
