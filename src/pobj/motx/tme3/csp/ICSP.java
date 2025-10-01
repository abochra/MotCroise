package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Interface pour matérialiser un problème CSP
 */
public interface ICSP {
	/**
	 * Accesseur des variables du problème
	 * @return la liste des variables
	 */
	public List<IVariable> getVars();
	
	/**
	 * Teste si un problème est encore satisfiable
	 * @return vrai ou faux
	 */
	public boolean isConsistent();
	
	/**
	 * Affecte une des variables du problèmes
	 * @param vi variable
	 * @param val valeur à affecter à la variable
	 * @return un nouveau problème CSP
	 */
	public ICSP assign(IVariable vi, String val);
}
