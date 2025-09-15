package pobj.motx.tme1;

public class Grille {
	private Case[][] matrice;
	
	// Constructeur de la classe Grille
	public Grille(int hauteur, int largeur) {
		 matrice = new Case[hauteur][largeur];
		 for (int i=0; i < hauteur; i++) {
			 for (int j=0; j < largeur; j++) {
				 matrice[i][j] = new Case(i,j,' ');
			 }
		 }
	 }
	
	// Accesseur qui retourne la case à la position (lig, col)
	public Case getCase(int lig, int col) {
		 /*(lig >= matrice.length || col >= matrice[0].length) {
			System.out.println("La position donnée est inaccessible :" + lig + "," + col);
			return null;
		} */
		System.out.println("ligne et colonne :" + lig +"," + col);
		return matrice[lig][col];
	}
	
	// Méthode standard qui affiche une grille sur la console
	@Override
	public String toString() {
		return GrilleLoader.serialize(this,false);
	}
	
	// Accesseur retournant le nombre de lignes
	public int nbLig() {
		return matrice.length;
	}
	
	// Accesseur retournant le nombre de colonnes 
	public int nbCol() {
		return matrice[0].length;
	}
	
	// Méthode qui retourne une copie à l'identique de la grille courante
	public Grille copy() {
		Grille new_g = new Grille(matrice.length, matrice[0].length);
		for (int i=0; i< new_g.matrice.length;i++){
			for (int j=0; j < new_g.matrice[0].length;j++) {
				new_g.matrice[i][j] = matrice[i][j].copieCase();
			}
		}
		return new_g;
	}
}
