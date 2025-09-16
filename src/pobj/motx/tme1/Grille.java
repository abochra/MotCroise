package pobj.motx.tme1;

/**
 * Classe de représentation de Grille
 */

public class Grille {
	/**
	 * Grille représentée par une matrice de cases
	 */
	private Case[][] matrice;
	
	/**
	 * Construit une grille de hauteur lignes sur largeur colonnes
	 * @param hauteur nombre de lignes de la grille
	 * @param largeur nombre de colonnes de la grille
	 */
	public Grille(int hauteur, int largeur) {
		 matrice = new Case[hauteur][largeur];
		 for (int i=0; i < hauteur; i++) {
			 for (int j=0; j < largeur; j++) {
				 matrice[i][j] = new Case(i,j,' ');
			 }
		 }
	 }
	
	/**
	 * Retourne la case à la position (lig,col)
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return la case à la position (lig,col)
	 */
	public Case getCase(int lig, int col) {
		return matrice[lig][col];
	}
	
	/**
	 * Affiche la grille sur la console
	 */
	@Override
	public String toString() {
		return GrilleLoader.serialize(this,false);
	}
	
	/**
	 * Accède au nombre de lignes de la grille
	 * @return nombre de lignes
	 */
	public int nbLig() {
		return matrice.length;
	}
	
	/**
	 * Accède au nombre de colonnes de la grille
	 * @return nombre de colonnes
	 */
	public int nbCol() {
		return matrice[0].length;
	}
	
	/**
	 * Retourne une copie à l'identique de la grille courante
	 * @return une copie de la grille
	 */
	public Grille copy() {
		Grille new_g = new Grille(nbLig(), nbCol());
		
		for (int i=0; i< new_g.nbLig();i++){
			for (int j=0; j < new_g.nbCol();j++) {
				new_g.matrice[i][j] = matrice[i][j].copieCase();
			}
		}
		return new_g;
	}
}
