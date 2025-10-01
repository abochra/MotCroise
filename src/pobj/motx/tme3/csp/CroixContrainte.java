package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.EnsembleLettre;
import pobj.motx.tme2.GrillePotentiel;

/**
 * Classe de la contrainte de croisement
 */
public class CroixContrainte implements IContrainte{
	private int m1;
	private int c1;
	private int m2;
	private int c2;
	
	/**
	 * Constructeur de la contrainte de croisement
	 * @param m1 indice du premier emplacement
	 * @param c1 indice de la case où a lieu ce croisement pour cet emplacement
	 * @param m2 indice du deuxieme emplacement
	 * @param c2 indice de la case où a lieu ce croisement pour cet emplacement
	 */
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}
	
	/**
	 * Modifie la grille passée en argument et retourne le nombre total de mots filtrés par son action
	 * @param grille
	 * @return nombre de mots filtrés
	 */
	public int reduce(GrillePotentiel grille) {
		int nb_mots_filtres = 0;
		List<Dictionnaire> domaines = grille.getMotsPot();
		Dictionnaire dico1 = domaines.get(m1);
		Dictionnaire dico2 = domaines.get(m2);
		
		EnsembleLettre l1 = new EnsembleLettre();
		l1 = dico1.lettrePossiblePosition(c1);
		
		EnsembleLettre l2 = new EnsembleLettre();
		l2 = dico2.lettrePossiblePosition(c2);
		
		EnsembleLettre s = l1.intersection(l2);
		
		if (l1.size() > s.size()) {
			nb_mots_filtres += dico1.filtreParIndice(c1, s);
		}
		if (l2.size() > s.size()) {
			nb_mots_filtres += dico2.filtreParIndice(c2, s);
		}
		return nb_mots_filtres;
	}
	
	/**
	 * Méthode adaptée pour tester l'égalité entre deux contraintes de croisement
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null) return false;
		CroixContrainte c = (CroixContrainte)other;
		if (c.m1 != m1 || c.c1 != c1 || c.m2 != m2 || c.c2 != c2) return false;
		return true;
	}
}
