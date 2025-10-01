package pobj.motx.tme3.test;

import pobj.motx.tme3.csp.*;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme2.*;
import pobj.motx.tme1.*;
import pobj.motx.tme3.adapt.*;
import org.junit.jupiter.api.Test;

public class GrilleSolverTestPersonnel {
	
	@Test
	public void testEasy() {
		Dictionnaire dico = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille grille = GrilleLoader.loadGrille("data/easy2.grl");
		
		System.out.println(grille);

		GrillePlaces grillepl = new GrillePlaces(grille);
		GrilleContrainte grillec = new GrilleContrainte(grillepl, dico);
		
		ICSP problem = new MotX(grillec);
		CSPSolver solver = new CSPSolver();
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testMedium() {
		Dictionnaire dico = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille grille = GrilleLoader.loadGrille("data/medium.grl");
		
		System.out.println(grille);

		GrillePlaces grillepl = new GrillePlaces(grille);
		GrilleContrainte grillec = new GrilleContrainte(grillepl, dico);
		
		ICSP problem = new MotX(grillec);
		CSPSolver solver = new CSPSolver();
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testHard() {
		Dictionnaire dico = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille grille = GrilleLoader.loadGrille("data/large4.grl");
		
		System.out.println(grille);

		GrillePlaces grillepl = new GrillePlaces(grille);
		GrilleContrainte grillec = new GrilleContrainte(grillepl, dico);
		
		ICSP problem = new MotX(grillec);
		CSPSolver solver = new CSPSolver();
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
		System.out.println(grille);
	}
	
}
