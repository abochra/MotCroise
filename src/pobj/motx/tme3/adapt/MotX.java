package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme3.csp.*;


public class MotX implements ICSP {
	private GrilleContrainte grillec;
	private List<IVariable> liste_dicos;
	
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
	
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return liste_dicos;
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return !grillec.isDead();
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		// TODO Auto-generated method stub
		if (!(vi instanceof DicoVariable)) {
			System.out.println("La variable n'est pas da la classe DicoVariable");
			return null;
		}
		DicoVariable dvi = (DicoVariable)vi;
		GrilleContrainte nv_grillec = grillec.fixer(dvi.getIndice(), val);
		return new MotX(nv_grillec);
	}

}
