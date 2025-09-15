package pobj.motx.tme1;

public class Case {
	private int ligne;
	private int colonne;
	private char character;
	
	// Constructeur de la classe Case
	public Case(int lig, int col, char c) {
		ligne = lig;
		colonne = col;
		character = c;
	}
	
	// Accesseur en lecture de l'attribut ligne
	public int getLig() {
		return ligne;
	}
	
	// Accesseur en lecture de l'attribut colonne
	public int getCol() {
		return colonne;
	}
	
	// Accesseur en lecture de l'attribut character
	public int getChar() {
		return character;
	}
	
	// Accesseur en écriture de l'attribut character
	public void setChar(char c) {
		character = c;
	}
	
	// Opération booléenne qui répond vrai si la case est vide (blanche représentée par un espace ' ')
	public boolean isVide() {
		return character == ' ';
	}
	
	// Opération booléenne qui répond vrai si la case est pleine (noire représentée par un asterix '*')
	public boolean isPleine() {
		return character == '*';
	}
	
	// Copie d'une case
	public Case copieCase() {
		return new Case(ligne, colonne, character);
	}
}
