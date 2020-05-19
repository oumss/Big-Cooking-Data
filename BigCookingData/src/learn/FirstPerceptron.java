package learn;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import persistance.IngredientPersistance;

public class FirstPerceptron {

	private FirstPerceptronEntry fpe = new FirstPerceptronEntry();
	private PerceptronUtility pu = new PerceptronUtility();

	public FirstPerceptron(FirstPerceptronEntry fpe, PerceptronUtility pu) {
		super();
		this.fpe = fpe;
		this.pu = pu;
	}

	public boolean resultPerceptron(int groupeCode) {
		double pasApp = fpe.getPasApp();
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> ing = ip.readAllIngredient();
		HashMap<Ingredient, Integer> ingredientEntry = fpe.getIngredientEntry();
		HashMap<Ingredient, Double> weightEntry = pu.initiWeightEntry(ingredientEntry);
		HashMap<Ingredient, Integer> vectorResultByGroupCode = pu.creatVectorResultByGroupCode(ingredientEntry,
				groupeCode);
		boolean bon = false;
		int iteration = 0;
		
		while (iteration != 100 && bon == false) {
			
			bon = true;
			for (Ingredient mapentry : ingredientEntry.keySet()) {
				// for (Ingredient mapentry2 : weightEntry.keySet()) {
				// double a = (Double) mapentry2.getValue();
				// if (mapentry.equals(mapentry2)) {
				/*
				 * System.out.println(weightEntry.containsKey(mapentry));
				 * System.out.println(ingredientEntry.get(mapentry));
				 * System.out.println(ingredientEntry.size());
				 * System.out.println(weightEntry.get(mapentry));
				 * System.out.println(weightEntry.size());
				 * System.out.println(vectorResultByGroupCode.get(mapentry));
				 */
				double sortie = pu.calculSortieNeurone(ingredientEntry.get(mapentry), weightEntry.get(mapentry));
				if (!pu.acceptSortie(ingredientEntry.get(mapentry), weightEntry.get(mapentry),
						vectorResultByGroupCode.get(mapentry))) {
					double newWeight = pu.newWeight(ingredientEntry.get(mapentry), weightEntry.get(mapentry), pasApp,
							sortie, vectorResultByGroupCode.get(mapentry));
					weightEntry.replace(mapentry, newWeight);
					
					bon = false;
				}

				// }
				// }

			}
			iteration++;
		}
		double resultat = pu.calculSortiePerceptron(ingredientEntry, weightEntry);
		return pu.HeavySidePerceptron(resultat, groupeCode);
	}

	public HashMap<Integer, Boolean> resultAllPerceptron() {

		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Integer> listgrp = ip.readAllSousCategorie();
		HashMap<Integer, Boolean> result = new HashMap<Integer, Boolean>();

		for (int i = 0; i < listgrp.size(); i++) {
			result.put(listgrp.get(i), resultPerceptron(listgrp.get(i)));
		}

		return result;
	}

	public FirstPerceptronEntry getFpe() {
		return fpe;
	}

	public void setFpe(FirstPerceptronEntry fpe) {
		this.fpe = fpe;
	}

	public PerceptronUtility getPu() {
		return pu;
	}

	public void setPu(PerceptronUtility pu) {
		this.pu = pu;
	}

}
