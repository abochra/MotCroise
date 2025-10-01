package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de l'ensemble des lettres
 */
public class EnsembleLettre {
	private List<Character> lettres;
	
	/**
	 * Constructeur de l'ensemble des lettres
	 */
	public EnsembleLettre() {
		lettres = new ArrayList<>();
	}
	
	/**
	 * Ajoute la lettre c dans l'ensemble des lettres 
	 */
	public void add(char c) {
		if (!lettres.contains(c)) {
			lettres.add(c);
		}
	}
	
	/**
	 * Retourne la taille de l'ensemble des lettres
	 * @return la taille
	 */
	public int size() {
		return lettres.size();
	}
	
	/**
	 * Retourne l'intersection de l'ensemble actuel et de l'ensemble ens
	 * @param ens
	 * @return l'intersection des 2 ensembles de lettres
	 */
	public EnsembleLettre intersection(EnsembleLettre ens) {
		EnsembleLettre inter = new EnsembleLettre();
		inter.lettres = new ArrayList<>(this.lettres);
		inter.lettres.retainAll(ens.lettres);
		return inter;
	}
	
	/**
	 * Vérifie si la lettre c est présente dans l'ensemble des lettres
	 * @param c la lettre
	 * @return vrai ou faux
	 */
	public boolean contains(char c) {
		return lettres.contains(c);
	}
	
	
}
