package src.jeu.gestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.entitees.Combattant;
import src.entitees.combattants.*;


public class GenCombattant {
    private static final List<String> noms = Arrays.asList("Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier","Pretre","Abomination");

    public static List<String> genNomCombattants() {
        return new ArrayList<>(noms);
    }

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

    public static void afficherMenuAlt() {
        List<String> noms = genNomCombattants();
        for (int i = 0; i < noms.size(); i++) {
            System.out.println((i + 1) + ". " + noms.get(i));
        }
    }

    public static int getNbCombattants() {
        return noms.size();
    }
}
