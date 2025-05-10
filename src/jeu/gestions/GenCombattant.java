package src.jeu.gestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.entitees.Combattant;
import src.entitees.combattants.*;

/**
 * Cette classe génère des combattants.
 * La classe GenCombattant permet de générer des combattants selon un choix ou un nom.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 */
public class GenCombattant {
    /**
     * Liste des noms de combattants disponibles.
     */
    private static final List<String> noms = Arrays.asList("Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier","Pretre","Abomination");

    /**
     * Getter de la liste de noms de combattants.
     * @return la liste de noms de combattants
     */
    public static List<String> genNomCombattants() {
        return new ArrayList<>(noms);
    }

    /**
     * Génère un combattant selon le choix de l'utilisateur.
     * @param choix le choix de l'utilisateur
     * @return un combattant
     */
    public static Combattant generer(int choix) {
        return switch(choix) {
            case 1 -> new Paladin();
            case 2 -> new Berserker();
            case 3 -> new Mage();
            case 4 -> new Archer();
            case 5 -> new Voleur();
            case 6 -> new Guerrier();
            case 7 -> new Pretre();
            case 8 -> new Abomination();
            default -> null;
        };
    }

    /**
     * Génère un combattant selon le nom du combattant avec un switch.
     * @param nom le nom du combattant
     * @return un combattant
     */
    public static Combattant genererParNom(String nom) {
        return switch (nom.toLowerCase()) {
            case "paladin" -> new Paladin();
            case "berserker" -> new Berserker();
            case "mage" -> new Mage();
            case "archer" -> new Archer();
            case "voleur" -> new Voleur();
            case "guerrier" -> new Guerrier();
            case "pretre" -> new Pretre();
            case "abomination" -> new Abomination();
            default -> null;
        };
    }

    /**
     * Méthode statique qui affiche le menu de sélection de combattants.
     */
    public static void afficherMenuAlt() {
        List<String> noms = genNomCombattants();
        for (int i = 0; i < noms.size(); i++) {
            System.out.println((i + 1) + ". " + noms.get(i));
        }
    }


    /**
     * Getter
     * @return le nombre de combattants (int)
     */
    public static int getNbCombattants() {
        return noms.size();
    }
}
