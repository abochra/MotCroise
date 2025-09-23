package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	/**
	 * Stockage des mots dans une liste
	 */
	private List<String> mots;
	
	/**
	 * Initialise la liste de mots
	 */
	public Dictionnaire() {
		mots= new ArrayList<>();
	}
	
	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}
	
	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}
	
	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}
	
	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}
	
	/**
	 * Retire les mots qui ne contiennent pas le caractère c en position i dans la chaine de caractères
	 * @param c caractère à avoir dans les mots
	 * @param i indice à laquelle il faut trouver le caractère c
	 * @return le nombre de mots supprimés
	 */
	public int filtreParLettre(char c, int i) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (i < mot.length() && mot.charAt(i) == c) {
				cible.add(mot);
			}else {
				cpt++;
			}
		}
		mots = cible;
		return cpt;
	}
	
	
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	
	/**
	 * Lit un fichier texte de mots (un mot par ligne)
	 * @param path chemin vers le fichier texte
	 * @return le dictionnaire crée
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				dico.add(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return dico;
	}
	
}
