package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;
import pobj.motx.tme3.csp.*;

public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;
	private GrillePlaces grillepl;
	private Dictionnaire dico;
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes = new ArrayList<>();
		detecterContraintes();
		propage();
	}
	
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	public void detecterContraintes() {
		List<Emplacement> emp = grillepl.getPlaces();
		
		for (int i=0; i < grillepl.getNbHorizontal();i++) {
			Emplacement e = emp.get(i);
			
			for (int j=0; j < emp.size();j++) {
				contraintes.add(new CroixContrainte(,,,));
			}
		}
		
	}
	
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces nv_grille = grillepl.fixer(m, soluce);
		return new GrilleContrainte(nv_grille, dico);
	}
	
	private boolean propage() {
		return true;
	}
}
