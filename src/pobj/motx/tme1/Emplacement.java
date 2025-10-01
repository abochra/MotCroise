package pobj.motx.tme1;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de représentation de l'emplacement des mots dans la grille
 */

public class Emplacement {
	/**
	 * Liste de cases qui représente les cases de la grille qui composent l'emplacement du mot
	 */
	private List<Case> cases;
	
	/**
	 * Construit un emplacement initialement vide
	 */
	public Emplacement() {
		cases = new ArrayList<>();
	}
	
	/**
	 * Ajoute une case à l'emplacement
	 * @param e la case à ajouter
	 */
	public void add(Case e) {
		cases.add(e);
	}
	
	/**
	 * Retourne la taille de l'emplacement
	 */
	public int size() {
		return cases.size();
	}
	
	/**
	 * Retrouve la case à l'indice i
	 * @param i l'indice où se trouve la case
	 * @return la case à l'indice i
	 */
	public Case getCase(int i) {
		return cases.get(i);
	}
	
	/**
	 * Vérifie si une case est vide dans la liste
	 * @return vrai ou faux
	 */
	public boolean hasCaseVide() {
		for (Case c : cases) {
			if (c.isVide()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Affiche le mot à cet emplacement
	 */
	public String toString() {
		StringBuilder mot = new StringBuilder();
        
        for (Case c : cases) {
            mot.append(c.getChar());
        }
        
        return mot.toString();
	}
}

