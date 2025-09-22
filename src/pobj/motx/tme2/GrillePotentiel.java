package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;


public class GrillePotentiel {
	
	private GrillePlaces grillepl;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		grillepl = grille;
		dico = dicoComplet;
		motsPot = new ArrayList<>();
		
		for (Emplacement e : grille.getPlaces()) {
			Dictionnaire domaines = dicoComplet.copy();
			domaines.filtreLongueur(e.size());
			
			for (int i=0; i < e.size();i++) {
				Case c = e.getCase(i);
				if (c.getChar() != ' ' && c.getChar() != '*') {
					domaines.filtreParLettre(c.getChar(), i);
				}	
			}
			motsPot.add(domaines);
			
		}
	}
	
	
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	public boolean isDead(){
		for (Dictionnaire domaine : motsPot) {
			if (domaine.size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces nv_grille = grillepl.fixer(m, soluce);
		return new GrillePotentiel(nv_grille, dico);
	}
}
