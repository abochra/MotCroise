package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;

/**
 * Classe de représentation de GrillePotentiel
 */
public class GrillePotentiel {
	/**
	 * Associe à chaque emplacement de mot un dictionnaire : son domaine potentiel
	 * Stocke la grille actuelle, le dictionnaire français complet et le domaine de chaque emplacement de la grille (dans le même ordre que les emplacements places dans GrillePlaces)
	 */
	private GrillePlaces grillepl;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	
	/**
	 * Initialise les attributs aux valeurs données et le domaine des emplacements
	 * Limite aussi les mots en filtrant le dictionnaire par longueur et en filtrant par une lettre à une position donnée
	 * @param grille la grille actuelle
	 * @param dicoComplet le dictionnaire français complet
	 */
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
	
	/**
	 * Deuxième constructeur pour préfiltrer les mots potentiels (BONUS 1)
	 * @param grille la grille actuelle
	 * @param dicoComplet le dictionnaire français complet
	 * @param potentielactu le potentiel actuel de chaque emplacement
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet, List<Dictionnaire> potentielactu) {
		grillepl = grille;
		dico = dicoComplet;
		motsPot = new ArrayList<>();
		List<Emplacement> emplacements = grille.getPlaces();
		
	    for (int i = 0; i < emplacements.size(); i++) {
	        Emplacement emp = emplacements.get(i);
	        Dictionnaire dico = potentielactu.get(i).copy(); // Préfiltrer les mots en fonction du potentiel actuel et non pas en fonction du dictionnaire
	  
	        for (int j = 0; j < emp.size(); j++) {
	            Case c = emp.getCase(j);
	            if (c.getChar() != ' ' && c.getChar() != '*') {
					dico.filtreParLettre(c.getChar(), j);
				}
	        }
	        motsPot.add(dico);
	    }
	}
	
	/**
	 * Accesseur de la grille
	 * @return la grille
	 */
	public GrillePlaces getGrille() {
		return grillepl;
	}
	
	/**
	 * Accesseur du dictionnaire
	 * @return le dictionnaire
	 */
	public Dictionnaire getDico() {
		return dico;
	}
	
	/**
	 * Renvoie la liste des domaines de chaque emplacement de la grille
	 * @return motsPot (liste des domaines)
	 */
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	/**
	 * Retourne vrai si et seulement si au moins un emplacement a un domaine potentiel vide
	 * @return un booléen
	 */
	public boolean isDead(){
		for (Dictionnaire domaine : motsPot) {
			if (domaine.size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Fixe un mot dans un emplacement sans modifier l'instance courante de la grille
	 * @param m indice de l'emplacement du mot
	 * @param soluce le mot à placer
	 * @return une nouvelle grille sur laquelle on a fixé la valeur du mot 
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces nv_grille = grillepl.fixer(m, soluce);
		return new GrillePotentiel(nv_grille, dico, getMotsPot());
	}
}
