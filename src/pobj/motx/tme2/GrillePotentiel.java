package pobj.motx.tme2;

import java.util.ArrayList;

public class GrillePotentiel {
	private GrillePlaces grillepl;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		grillepl = grille;
		dico = dicoComplet;
		motsPot = new ArrayList<>();
	}
	
	
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	public boolean isDead(){
		
	}
}
