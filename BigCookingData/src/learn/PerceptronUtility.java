package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import business.Ingredient;
import persistance.IngredientPersistance;

public class PerceptronUtility {

	public PerceptronUtility() {
	}

	public void initiWeightEntry(FirstPerceptronEntry perceptronEntry) {

		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> a = ip.readAllIngredient();

		for (int i = 0; i < 2499; i++) {
			perceptronEntry.getWeightEntry().put(a.get(i), Math.random());
		}

		/*
		 * for(Map.Entry<Ingredient,Double> mapEntry :
		 * perceptronEntry.getWeightEntry().entrySet()) {
		 * System.out.println(mapEntry.getValue());
		 * System.out.println(mapEntry.getKey().getId_ingredient());
		 * System.out.println("\n"); }
		 * System.out.println(perceptronEntry.getWeightEntry().size());
		 */
	}

	public void initiIngredienttEntry(FirstPerceptronEntry perceptronEntry) {

		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> a = ip.readAllIngredient();

		for (int i = 0; i < 2499; i++) {
			perceptronEntry.getWeightEntry().put(a.get(i), 0.0);
		}
		/*
		 * for(Map.Entry<Ingredient,Double> mapEntry :
		 * perceptronEntry.getWeightEntry().entrySet()) {
		 * System.out.println(mapEntry.getValue());
		 * System.out.println(mapEntry.getKey().getId_ingredient());
		 * System.out.println("\n"); }
		 * System.out.println(perceptronEntry.getWeightEntry().size());
		 */
	}

	public double calculSortieNeurone(int entry, double weight) {
		return entry * weight;
	}

	public double newWeight(int entry, double weight, double pasApp, double sortie, double sortieD) {
		return weight + pasApp * (sortieD - sortie) * entry;
	}

	public boolean acceptSortie(int entry, double weight, int sortieD, double error) {
		if (Math.abs(calculSortieNeurone(entry, weight) - sortieD) < 0.1) {
			return true;
		}
		return false;
	}

	public double calculSortiePerceptron(HashMap<Ingredient, Integer> perEntry, HashMap<Ingredient, Double> weight) {
		double result = 0.0;
		for (Map.Entry<Ingredient, Integer> mapPerEntry : perEntry.entrySet()) {
			for (Map.Entry<Ingredient, Double> mapWeight : weight.entrySet()) {
				if (mapPerEntry.getKey().equals(mapWeight.getKey())) {
					result = result + calculSortieNeurone(mapPerEntry.getValue(), mapWeight.getValue());
				}
			}
		}
		return result;
	}

	// Fonction qui crée le vecteur de resultat attendu pour chaque catégories

	public ArrayList<HashMap<Integer, ArrayList<Ingredient>>> creatVectorByGroup() {
		ArrayList<HashMap<Integer, ArrayList<Ingredient>>> result = new ArrayList<HashMap<Integer, ArrayList<Ingredient>>>();
		IngredientPersistance ip = new IngredientPersistance();

		ArrayList<Integer> listGroup = ip.readAllSousCategorie();

		for (int i : listGroup) {

			ArrayList<Ingredient> ingredients = ip.readIngredientsBySousCategorie(i);
			HashMap<Integer, ArrayList<Ingredient>> vector = new HashMap<Integer, ArrayList<Ingredient>>();

			vector.put(i, ingredients);

			result.add(vector);

		}
		return result;
	}

	public ArrayList<HashMap<Ingredient, Double>> creatResultVectorByGroup() {

		ArrayList<HashMap<Ingredient, Double>> result = new ArrayList<HashMap<Ingredient, Double>>();

		IngredientPersistance ip = new IngredientPersistance();

		ArrayList<Ingredient> ingredients = ip.readAllIngredient();

		for (HashMap<Integer, ArrayList<Ingredient>> i : creatVectorByGroup()) {

			HashMap<Ingredient, Double> vector = new HashMap<Ingredient, Double>();
			ArrayList<ArrayList<Ingredient>> aaa = (ArrayList<ArrayList<Ingredient>>) i.values();
			for (Ingredient ing : ingredients) {
				if (i.values().contains(ing)) {
					vector.put(ing, 1.0);
					System.out.println("yes");
				} else {
					vector.put(ing, 0.0);
					// System.out.println("no");
				}

			}

			result.add(vector);

		}
		return result;
	}

	public HashMap<Ingredient, Double> CreatVectorRestultByGroupCode(int groupeCode) {

		IngredientPersistance ip = new IngredientPersistance();

		ArrayList<Ingredient> ingredients = ip.readAllIngredient();

		HashMap<Ingredient, Double> a = new HashMap<Ingredient, Double>();

		for (Ingredient ing : ingredients) {
			if (ing.getAlim_ssgrp_code() == groupeCode) {
				a.put(ing, 1.0);

			} else {
				a.put(ing, 0.0);
			}
		}

		return a;

	}
}