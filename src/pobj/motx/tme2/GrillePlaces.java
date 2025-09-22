package pobj.motx.tme2;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;

public class GrillePlaces {
	
	private Grille grille;
	private List<Emplacement> places;
	private int nbHorizontal;
	
	public GrillePlaces(Grille grille) {
		this.grille = grille;
		places = new ArrayList<>();
		nbHorizontal = 0;
		for (int i=0; i< grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
			nbHorizontal = places.size();
		}
		for (int j=0; j<grille.nbCol();j++) {
			cherchePlaces(getCol(j));
		}
	}
	
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	
	private List<Case> getLig(int lig){
		List<Case> ligne = new ArrayList<>();
		for (int col=0; col < grille.nbCol();col++) {
			ligne.add(grille.getCase(lig, col));
		}
		return ligne;	
	}
	
	private List<Case> getCol(int col){
		List<Case> colonne = new ArrayList<>();
		for (int lig=0; lig < grille.nbLig(); lig++) {
			colonne.add(grille.getCase(lig, col));
		}
		return colonne;
	}
	
	private void cherchePlaces(List<Case> cases) {
		Emplacement empl = new Emplacement();
		for (Case c : cases) {
			if (!c.isPleine()) {
				empl.add(c);
			}else {
				if (empl.size() >= 2) {
					places.add(empl);
				}
				empl = new Emplacement();
			}
		}
		if (empl.size() >= 2) {   // Dernier emplacement à ajouter
			places.add(empl);
		}
	}
	
	public GrillePlaces fixer(int m, String soluce) {
		Grille nv_grille = grille.copy();
		
		Emplacement emp_mot = places.get(m);
		
		for (int i=0; i < emp_mot.size() && i < soluce.length();i++) {
			Case c = emp_mot.getCase(i);
			nv_grille.getCase(c.getLig(), c.getCol()).setChar(soluce.charAt(i));
		}
		return new GrillePlaces(nv_grille);
		
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GrillePlaces : ").append(places.size()).append(" emplacements\n");
		sb.append("Places horizontaux : ").append(nbHorizontal).append(" emplacements\n");
		sb.append("Places verticaux : ").append(places.size() - nbHorizontal).append(" emplacements\n");
		
		for (int k=0; k < places.size(); k++) {
			sb.append(k).append(":").append(places.get(k).toString()).append("\n");
		}
		return sb;
	}
}
