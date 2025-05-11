package src.entitees;
import src.jeu.gestions.Equipe;

/**
 * Classe abstraite Combattant.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 */
public abstract class Combattant {

    private final int pvMax;
    private int pv;
    
    //La ressource courage diminue lorsque qu'un combattant prend des dégâts, lorsque celle-ci atteint 0 le combattant à une chance de fuir.
    private final int courageMax;
    private int courage;

    private final int attaque;
    private final int defense;
    private final int vitesse;

    //l'indice fuite augmente dans le cas ou le combattant fuis le combat
    private int fuite = 0;

    private static int idCpt;
    private final int id;

    /**
     * Creation d'un combattant
     * @param pvMax points de vie max du combattant
     * @param attaque nombre de dégats infligés par le combattant
     * @param defense degat maximum que le combattant peut encaisser
     * @param vitesse vitesse du combattant
     * @param courageMax courage max du combattant 
     */
    public Combattant(int pvMax, int attaque, int defense, int vitesse, int courageMax) {
        this.pv = pvMax;
        this.pvMax = pvMax;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.courage = courageMax;
        this.courageMax = courageMax;
        this.id = idCpt++;
    }

    /**
     * Offre au classes differents types de possibilités d'actions (ex : Le prêtre peut soigner OU attaquer)
     * @param ennemie cible choisie parmis les combattants adverses
     * @param alliée cible choisie parmis les combattants alliés
     */
    public void action(Equipe ennemie, Equipe alliee) {
        attaquer(ennemie, alliee);
    }

    /**
     * Attaque un combattant ennemi
     * @param ennemie cible choisie parmis les combattants adverses
     */
    public void attaquer(Equipe ennemie, Equipe alliee) {
        //Selection d'un combattant aléatoire, l'adversaire prend des dégâts
        Combattant adversaire = ennemie.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        //Affichage des dégâts infligés ainsi que la vie de l'ennemi touché
        System.out.println("🗡️  " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

   /**
     * Permet au combattant de subir des dégâts
     * @param attaquant prend en compte l'attaquant dans le cas d'une contre-attaque
     */
    public void prendreDegat(Combattant attaquant) {
        //Tirage pour savoir si le combattant fuit si le courage est a 0
        int r = (int)(3*Math.random());

        //Si le combattant esquive ou si la defense du combattant est superieur a l'attaque de l'adversaire le combattant adverse ne subit pas de dégâts
        if (activerEsquive()) {
            System.out.println("🛡️ Le "+getNom()+" esquive !");
            return;
        }
        if (defense >= attaquant.getAttaque()) {
            System.out.println("🛡️ Le "+getNom()+" bloque l'attaque !");
            return;
        }
        
        int degat = attaquant.calculerDegat(this);
        //Reduction du courage, si le tirage = 1 alors le combattant prend la fuite
        soustraireCourage(10);
        if(courage<=0 && r == 1) {
            fuite++;
        }
        //Reduction des pv du combattant
        if(degat > 0) pv = Math.max(0, pv - degat);
    }

     /**
     * Calcul les dégats infligés par le combattant
     * @param cible le combattant atteint par l'attaque
     * @return les dégats infligés
     */
    public int calculerDegat(Combattant cible) {
        return getAttaque() - cible.getDefense();
    }

    /**
     * Si le combattant est en vie alors il peut se regenere sans dépasser sa vie max
     * @param pv que le combattant va régénérer
     */
    public void regenererPV(int pv) {
        if(estEnVie()) {
            if(this.pv +pv > this.pvMax) this.pv = this.pvMax;
            else this.pv += pv;
        }
    }

    /**
     * Ajoute du courage au combattant
     * @param courage que le combattant va régénérer
     */
    public void regenererCourage(int courage){
        if(estEnVie())this.courage += courage;
    }
    
    /**
     * Reduis le courage
     * @param courage que le combattant va régénérer
     */
    public void soustraireCourage(int courage) {
    if (estEnVie()) this.courage -= courage;
    }

    /**
     * Toute les classes(sauf voleur) on 5% de chance d'esquiver un coup
     * @return true si le voleur esquive sinon false
     */
    public boolean activerEsquive() {
        int r = (int)(21*Math.random());
        if(r == 1) {
            return true;
        }
        return false;
    }

    /**
     * Verifie si le combattant est toujours en vie
     * @return true si le combattant est en vie ou n'a pas fui sinon false
     */
    public boolean estEnVie(){
        return (fuite < 1 && pv > 0);
    }

        /**
     * Affiche si le combattant et vivant, mort ou s'est enfui
     * @return String correspondant
     */
    public String mortOuVivant() {
        String s = "";
        if(estEnVie()) {
            s += "Vivant";
        }else if (!estEnVie() && fuite == 1) {
            s += "Fuite";
        }else{
            s += "Mort";
        }
        return s;
    }

    /**
     * Initiale+pv/pvMax du combattant.
     * @return String correspondant
     */
    @Override
    public abstract String toString();

    /* Getters */
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
        return id;
    }

    public int getCourageMax() {
        return courageMax;
    }
    
    public int getCourage() {
        return courage;
    }

    public abstract String getNom();

}
