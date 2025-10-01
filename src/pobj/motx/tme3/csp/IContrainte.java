package pobj.motx.tme3.csp;

import pobj.motx.tme2.GrillePotentiel;

/**
 * Interface de contrainte abstraite
 */
public interface IContrainte {
	/**
	 * Modifie la grille passée en argument et retourne le nombre total de mots filtrés par son action
	 * @param grille
	 * @return nombre de mots filtrés
	 */
	public int reduce(GrillePotentiel grille);
}
