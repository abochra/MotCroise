package pobj.motx.tme1;

/**
 * Classe de représentation de Case
 */

public class Case {
	/**
	 * Coordonnées de la case : la ligne, la colonne et le caractère qui représente la valeur dans la case
	 */
	private int ligne;  
	private int colonne;
	private char character;
	
	/**
	 * Construit une case de coordonnées initiales spécifiées
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @param c  le caractère de la case
	 */
	public Case(int lig, int col, char c) {
		ligne = lig;
		colonne = col;
		character = c;
	}
	
	/**
	 * Accède à la ligne de cette case
	 * @return la ligne de la case
	 */
	public int getLig() {
		return ligne;
	}
	
	/**
	 * Accède à la colonne de cette case
	 * @return la colonne de la case
	 */
	public int getCol() {
		return colonne;
	}
	
	/**
	 * Accède au caractère de cette case
	 * @return le caractère de la case
	 */
	public char getChar() {
		return character;
	}
	
	/**
	 * Modifie le caractère de cette case par c
	 * @param c le nouveau caractère
	 */
	public void setChar(char c) {
		character = c;
	}
	
	/**
	 * Répond vrai si la case est vide (blanche représentée par un espace ' ')
	 * @return vrai ou faux
	 */
	public boolean isVide() {
		return character == ' ';
	}
	
	/**
	 * Répond vrai si la case est pleine (noire représentée par un asterix '*')
	 * @return vrai ou faux
	 */
	public boolean isPleine() {
		return character == '*';
	}
	
	/**
	 * Copie cette case 
	 * @return une case ayant les mêmes coordonnées que celle ci
	 */
	public Case copieCase() {
		return new Case(ligne, colonne, character);
	}
}
