package learn;

import java.util.HashMap;
import java.util.Map;

import business.Ingredient;

public class FirstPerceptron {

	public boolean resultPerceptron(HashMap<Ingredient, Integer> ingredientEntry, HashMap<Ingredient, Double> weightEntry, HashMap<Ingredient, Integer> vectorResultByGroupCode, double pasApp, int groupeCode) {

		/*
		 * Algo Perceptron :
		 * 
		 * Entrée : vecteur d'entrée : ve : HashMap<Ingredient, Integer> 
		 * vecteur de poids : vp : HashMap<Ingredient, Double>
		 * vecteur de resultats attendues : vr : HashMap<Ingredient, Integer> 
		 * Pas d'apprentissage : pa : Double (= 0,1)
		 * DEBUT:
		 * 	bon = FALSE
		 * 	i = 0
		 * 	tant que i != 50 OU bon = FALSE
		 * 		bon = TRUE
		 * 		Pour chaque élément de ve faire
		 *			sortie = ve.Integer x vp.Double 
		 *			si (sortie != vr)
		 *				modifierPoid(ve.Integer,vp.Double,sortie,vr.Integer,pa)
		 *				bon = FALSE
		 * 			finsi
		 * 		finpour
		 * 		i=i+1
		 * 	fintantque
		 * 
		 * 	resultat = Somme(ve.Integer x vp.Double)
		 * 
		 *	return HeavySide(resultat)
		 * 
		 * FIN
		 * 
		 */
		PerceptronUtility pu = new PerceptronUtility();
		boolean bon = false;
		int iteration = 0;
		while(iteration != 50 && bon == false) {
			
			bon = true;
			for (Ingredient mapentry : ingredientEntry.keySet()) {
						//double a = (Double) mapentry2.getValue();
						double sortie = pu.calculSortieNeurone(ingredientEntry.get(mapentry),weightEntry.get(mapentry));
						if(pu.acceptSortie(ingredientEntry.get(mapentry), weightEntry.get(mapentry), vectorResultByGroupCode.get(mapentry))) {
							double newWeight = pu.newWeight(ingredientEntry.get(mapentry), weightEntry.get(mapentry), pasApp, sortie, vectorResultByGroupCode.get(mapentry));
							weightEntry.replace(mapentry, newWeight);
							bon = false;
						}	
			}
			iteration++;
			}
		
		double resultat = pu.calculSortiePerceptron(ingredientEntry, weightEntry);
		return pu.HeavySidePerceptron(resultat, groupeCode);
		}

}
