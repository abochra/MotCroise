package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	private List<Character> lettres;
	
	public EnsembleLettre() {
		lettres = new ArrayList<>();
	}
	
	public void add(char c) {
		if (!lettres.contains(c)) {
			lettres.add(c);
		}
	}
	
	public int size() {
		return lettres.size();
	}
	
	public EnsembleLettre intersection(EnsembleLettre ens) {
		EnsembleLettre inter = new EnsembleLettre();
		inter.lettres = new ArrayList<>(this.lettres);
		inter.lettres.retainAll(ens.lettres);
		return inter;
	}
	
	public boolean contains(char c) {
		return lettres.contains(c);
	}
	
	
}
