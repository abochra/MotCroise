package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme3.csp.*;

import pobj.motx.tme3.csp.IVariable;

public class DicoVariable implements IVariable {
	private int indice;
	private GrilleContrainte grille;
	
	/**
	 * Constructeur d'un Design Pattern Adapter pour transformer un emplacement de mot en variable CSP
	 * @param index
	 * @param gp
	 */
	public DicoVariable(int index, GrilleContrainte gp) {
		indice = index;
		grille = gp;
	}
	
	/**
	 * Accesseur de l'indice de l'emplacement de mot correspondant
	 * @return l'indice
	 */
	public int getIndice() {
		return indice;
	}
	
	/**
	 * Liste des domaines associée à l'emplacement du mot dans la grille
	 * @return la liste des domaines 
	 */
	@Override
	public List<String> getDomain() {
		// TODO Auto-generated method stub
		List<String> domaine = new ArrayList<>();
        Dictionnaire dico = grille.getMotsPot().get(indice);
        for (int i = 0; i < dico.size(); i++) {
            domaine.add(dico.get(i));
        }
        return domaine;
	}
	
	@Override
	public String toString() {
		return "DicoVariable[" + indice + ", domaine=" + getDomain().size() + " mots]";
	}

}
