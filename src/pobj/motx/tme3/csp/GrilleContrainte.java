package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;

/**
 * Classe de la détection des contraintes
 */
public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;
	
	/**
	 * Constructeur de la classe 
	 * @param grille
	 * @param dicoComplet
	 */
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes = new ArrayList<>();
		detecterContraintes();
		propage();
		
	}
	
	/**
	 * Deuxième constructeur de la classe pour préfiltrer les mots potentiels (BONUS 1)
	 * @param grille la grille actuelle
	 * @param dicoComplet le dictionnaire français complet
	 * @param potentielactu le potentiel actuel de chaque emplacement
	 */
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet, List<Dictionnaire> potentielactu) {
		super(grille,dicoComplet,potentielactu);
		contraintes = new ArrayList<>();
		detecterContraintes();
		propage();
	}
	
	/**
	 * Accesseur de la liste des contraintes
	 * @return la liste des contraintes
	 */
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	/**
	 * Détecte toutes les contraintes de croisement dans la grille
	 */
	public void detecterContraintes() {
		List<Emplacement> emplacements = getGrille().getPlaces();
		int nbH = getGrille().getNbHorizontal();
		
		for (int h=0; h < nbH;h++) {
			Emplacement emph = emplacements.get(h);
			
			for (int v=nbH; v < emplacements.size();v++) {
				
				Emplacement empv = emplacements.get(v);
				
				for (int i = 0; i < emph.size();i++) {
					
					Case caseh = emph.getCase(i);
					
					for (int j =0; j < empv.size();j++) {
						
						Case casev = empv.getCase(j);
						
						if (caseh.getLig() == casev.getLig() && caseh.getCol() == casev.getCol()) {
							if (caseh.isVide() || caseh.isPleine()) {
								contraintes.add(new CroixContrainte(h,i,v,j));
							}
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * Fixe un mot dans un emplacement sans modifier l'instance courante de la grille
	 * @param m indice de l'emplacement du mot
	 * @param soluce le mot à placer
	 * @return une nouvelle grille sur laquelle on a fixé la valeur du mot
	 */
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces nv_grille = getGrille().fixer(m, soluce);
		return new GrilleContrainte(nv_grille, getDico(), getMotsPot());
	}
	
	/**
	 * Propagation des contraintes 
	 * @return vrai ou faux 
	 */
	private boolean propage() {
        while (true) {
            int totalFiltre = 0;
            
            for (IContrainte contrainte : contraintes) {
                totalFiltre += contrainte.reduce(this);
            }
            
            if (isDead()) {
                return false;
            }
            
            if (totalFiltre == 0) {
                return true;
            }
        }
    }
	
}
