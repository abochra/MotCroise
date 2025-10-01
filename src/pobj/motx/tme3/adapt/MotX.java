package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme3.csp.*;

/**
 * Classe adaptateur pour transformer une grille de mots croisés en problème CSP
 */
public class MotX implements ICSP {
	private GrilleContrainte grillec;
	private List<IVariable> liste_dicos;
	
	/**
	 * Constructeur pour transformer une grille de mots croisés en problème CSP 
	 * @param gc
	 */
	public MotX(GrilleContrainte gc) {
		grillec = gc;
		liste_dicos = new ArrayList<>();
		
		List<Emplacement> emps = gc.getGrille().getPlaces();
		for (int i=0; i < emps.size();i++) {
			Emplacement e = emps.get(i);
			if (e.hasCaseVide()) {
				liste_dicos.add(new DicoVariable(i,gc));
			}
		}
	}
	
	/**
	 * Accesseur des variables du problème
	 * @return la liste des variables
	 */
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return liste_dicos;
	}
	
	/**
	 * Teste si un problème est encore satisfiable
	 * @return vrai ou faux
	 */
	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return !grillec.isDead();
	}

	/**
	 * Affecte une des variables du problèmes
	 * @param vi variable
	 * @param val valeur à affecter à la variable
	 * @return un nouveau problème CSP
	 */
	@Override
	public ICSP assign(IVariable vi, String val) {
		// TODO Auto-generated method stub
		if (!(vi instanceof DicoVariable)) {
			System.out.println("La variable n'est pas de la classe DicoVariable");
			return null;
		}
		DicoVariable dvi = (DicoVariable)vi;
		GrilleContrainte nv_grillec = grillec.fixer(dvi.getIndice(), val);
		return new MotX(nv_grillec);
	}

}
