package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Berserker extends Combattant{

   /**
     * Création du berserker
     */
    public Berserker() {
        super(220, 55, 10, 50, 120);
    }

    /**
     * Le berserker attaque une fois de plus si ses pv son en dessous ou égaux à 80
     * @param ennemis cible aléatoire choisie parmis les combattant
     */
    @Override
    public void attaquer(Equipe ennemis) {
        //Attaque un adversaire choisit aléatoirement
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        //Affichage des dégâts infligés ainsi que la vie de l'ennemi touché
        System.out.println(getNom() + "["+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + Math.max(0, getAttaque()-adversaire.getDefense()) + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
        //Si les pv du berserker sont en dessous de 80 et qu'il est vivant il frappe a nouveau
        if(getPV() <= 80 && estEnVie() && ennemis.aDesVivants()) {
            //nouvelle selection de l'adversaire a attaquer
            adversaire = ennemis.choisirCombattantAleatoire();
            adversaire.prendreDegat(this);
            //Affichage de l'attaque suplémentaire
            System.out.println("Attaque suplémentaire du Berserker !");
           System.out.println(getNom() + "["+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + Math.max(0, getAttaque()-adversaire.getDefense()) + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
        }
    }

    @Override
    public String toString() {
        return "B["+getPV()+" /"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Berseker";
    }
}