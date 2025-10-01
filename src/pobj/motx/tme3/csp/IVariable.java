package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Interface pour matérialiser chaque variable
 */
public interface IVariable {
	/**
	 * Renvoie l'ensemble des valeurs que peut prendre une variable
	 * @return une liste des valeurs
	 */
	public List<String> getDomain();
}
