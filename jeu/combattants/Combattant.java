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
    private int attaque;
    private int defense;
    private int vitesse;
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
    Combattant(int pvMax, int attaque, int defense, int vitesse){
        this.pv = pvMax;
        this.pvMax = pvMax;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        cpt++;
    }

    /**
     * 
     */
    public void cible(Equipe equipe) {
        cible =  equipe.choisirCombattantAleatoire();
    }

    /**
     * 
     * @param ennemis
     */
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        if(adversaire == null || !adversaire.estEnVie()) return;
        adversaire.prendreDegat(this);
        System.out.println(adversaire.getNom()+"[Equipe "+ennemis.getID()+"] "+" a subit une attaque de "+getNom()+"lui infligeant "+getAttaque()+"de dégats || pv: "+adversaire.getPV()+"/"+adversaire.getPvMax());
    }

    /**
     * 
     * @param attaquant
     */
    public void prendreDegat(Combattant attaquant) {
        if (activerEsquive() || (attaquant.getAttaque() <= getDefense())) {
            return;
        }
        int degat = attaquant.calculerDegat(this);
        if(degat > 0) pv = Math.max(0, pv - degat);
        activerPassive(attaquant);
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

    /**
     * 
     * @return
     */
    public boolean activerEsquive() {
        int r = (int)(21*Math.random());
        if(r == 1) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param cible
     */
    public void activerPassive(Combattant cible) {
    }

    /**
     * 
     * @return
     */
    public boolean estEnVie(){
        if(pv > 0) {
            return true;
        }
        return false;
    }

    /**
     * 
     */
    public String toString(){
        return "Combattant";
    }

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
  
    public abstract String getNom();

}
