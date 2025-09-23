package pobj.motx.tme2;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;

/**
 * Classe de représentation de GrillePlaces
 */

public class GrillePlaces {
	
	/**
	 * Stocke la grille qu'elle explore, la liste des emplacements des mots de la grille et le nombre d'emplacements horizontaux
	 */
	private Grille grille;
	private List<Emplacement> places;
	private int nbHorizontal;
	
	/**
	 * Construit la liste des emplacements des mots se trouvant sur la grille
	 * @param grille la grille à explorer
	 */
	public GrillePlaces(Grille grille) {
		this.grille = grille;
		places = new ArrayList<>();
		nbHorizontal = 0;
		for (int i=0; i< grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
			nbHorizontal = places.size();
		}
		for (int j=0; j<grille.nbCol();j++) {
			cherchePlaces(getCol(j));
		}
	}
	
	/**
	 * Retourne les emplacements détectés
	 * @return la liste des emplacements détectés
	 */
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	/**
	 * Retourne le nombre d'emplacements horizontaux
	 * @return le nbHorizontal
	 */
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	
	/**
	 * Retourne les cases qui constituent la ligne lig
	 * @param lig la ligne dont les cases sont retournées
	 * @return la liste des cases de la ligne lig
	 */
	private List<Case> getLig(int lig){
		List<Case> ligne = new ArrayList<>();
		for (int col=0; col < grille.nbCol();col++) {
			ligne.add(grille.getCase(lig, col));
		}
		return ligne;	
	}
	
	/**
	 * Retourne les cases qui constituent la colonne col
	 * @param col la colonne dont les cases sont retournées
	 * @return la liste des cases de la colonne col
	 */
	private List<Case> getCol(int col){
		List<Case> colonne = new ArrayList<>();
		for (int lig=0; lig < grille.nbLig(); lig++) {
			colonne.add(grille.getCase(lig, col));
		}
		return colonne;
	}
	
	/**
	 * Cherche les emplacements dans la liste de cases fournie et les ajoute à la liste
	 * @param cases la liste des cases où a lieu la recherche
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement empl = new Emplacement();
		for (Case c : cases) {
			if (!c.isPleine()) {
				empl.add(c);
			}else {
				if (empl.size() >= 2) {  
					places.add(empl);
				}
				empl = new Emplacement();
			}
		}
		if (empl.size() >= 2) {   // Dernier emplacement à ajouter
			places.add(empl);
		}
	}
	
	/**
	 * Fixe un mot dans un emplacement sans modifier l'instance courante de la grille
	 * @param m indice de l'emplacement du mot
	 * @param soluce le mot à placer
	 * @return une nouvelle grille sur laquelle on a fixé la valeur du mot
	 */
	public GrillePlaces fixer(int m, String soluce) {
		Grille nv_grille = grille.copy();
		
		Emplacement emp_mot = places.get(m);
		
		for (int i=0; i < emp_mot.size() && i < soluce.length();i++) {
			Case c = emp_mot.getCase(i);
			nv_grille.getCase(c.getLig(), c.getCol()).setChar(soluce.charAt(i));
		}
		return new GrillePlaces(nv_grille);
		
	}
	
	/**
	 * Affiche les emplacements de mots détectés de façon lisible
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GrillePlaces : ").append(places.size()).append(" emplacements\n");
		sb.append("Places horizontaux : ").append(nbHorizontal).append(" emplacements\n");
		sb.append("Places verticaux : ").append(places.size() - nbHorizontal).append(" emplacements\n");
		
		for (int k=0; k < places.size(); k++) {
			sb.append(k).append(":").append(places.get(k).toString()).append("\n");
		}
		return sb.toString();
	}
}
