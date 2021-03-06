package learn;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.User;
import persistance.IngredientPersistance;
import persistance.WeightIngredientPersistence;

public class PerceptronUtility {

	public PerceptronUtility() {
	}

	public HashMap<Ingredient, Double> initiWeightEntry(HashMap<Ingredient, Integer> ingredientEntry) {

		// IngredientPersistance ip = new IngredientPersistance();
		// ArrayList<Ingredient> a = ip.readAllIngredient();
		HashMap<Ingredient, Double> weightEntry = new HashMap<Ingredient, Double>();
		for (Ingredient ing : ingredientEntry.keySet()) {
			weightEntry.put(ing, Math.random());
		}

		/*
		 * for(Map.Entry<Ingredient,Double> mapEntry :
		 * perceptronEntry.getWeightEntry().entrySet()) {
		 * System.out.println(mapEntry.getValue());
		 * System.out.println(mapEntry.getKey().getId_ingredient());
		 * System.out.println("\n"); }
		 * System.out.println(perceptronEntry.getWeightEntry().size());
		 */
		return weightEntry;
	}
	/*
	 * public void initiIngredienttEntry(FirstPerceptronEntry perceptronEntry) {
	 * 
	 * IngredientPersistance ip = new IngredientPersistance(); ArrayList<Ingredient>
	 * a = ip.readAllIngredient();
	 * 
	 * for (int i = 0; i < 2499; i++) {
	 * perceptronEntry.getWeightEntry().put(a.get(i), 0.0); } }
	 */

	public double calculSortieNeurone(int entry, double weight) {
		return entry * weight;
	}

	public double newWeight(int entry, double weight, double pasApp, double sortie, double sortieD) {
		return weight + pasApp * (sortieD - sortie) * entry;
	}

	public boolean acceptSortie(int entry, double weight, int sortieD) {
		if (Math.abs(calculSortieNeurone(entry, weight) - sortieD) < 0.0001) {
			return true;
		}
		return false;
	}

	public double calculSortiePerceptron(HashMap<Ingredient, Integer> perEntry, HashMap<Ingredient, Double> weight) {
		double result = 0.0;
		for (Ingredient mapPerEntry : perEntry.keySet()) {
			result = result + calculSortieNeurone(perEntry.get(mapPerEntry), weight.get(mapPerEntry));
		}
		return result;
	}
	/*
	 * �a c'est pour garder l'ancienne fonction calculSortiePerceptron
	 * 
	 * 
	 * 
	 * public double calculSortiePerceptron(HashMap<Ingredient, Integer> perEntry,
	 * HashMap<Ingredient, Double> weight) { double result = 0.0; for
	 * (Map.Entry<Ingredient, Integer> mapPerEntry : perEntry.entrySet()) { for
	 * (Map.Entry<Ingredient, Double> mapWeight : weight.entrySet()) { if
	 * (mapPerEntry.getKey().equals(mapWeight.getKey())) { result = result +
	 * calculSortieNeurone(mapPerEntry.getValue(), mapWeight.getValue()); } } }
	 * return result; }
	 */

	/**
	 * Fonction qui cr�e une liste qui pour chaque groupe, cr�e le vecteur
	 * d'ingredient de ce groupe
	 * 
	 * @return
	 */
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

	/**
	 * Fonction qui cr�e le vecteur de resultat attendu pour une seule cat�gorie
	 * 
	 * @param groupeCode
	 * @return
	 */
	public HashMap<Ingredient, Integer> creatVectorResultByGroupCode(HashMap<Ingredient, Integer> ingredientEntry,
			int groupeCode) {

		// IngredientPersistance ip = new IngredientPersistance();

		// ArrayList<Ingredient> ingredients = ip.readAllIngredient();

		HashMap<Ingredient, Integer> a = new HashMap<Ingredient, Integer>();

		for (Ingredient ing : ingredientEntry.keySet()) {
			if (ing.getAlim_ssgrp_code() == groupeCode) {
				a.put(ing, 1);

			} else {
				a.put(ing, 0);
			}
		}

		return a;

	}

	/**
	 * Fonction qui cr�e les vecteurs de resultat attendu pour chaque cat�gories
	 * 
	 * @return
	 */
	/*
	 * public HashMap<Integer,HashMap<Ingredient, Integer>>
	 * creatAllResultVectorByGroup(HashMap<Ingredient, Integer> ingredientEntry) {
	 * IngredientPersistance ip = new IngredientPersistance(); ArrayList<Integer>
	 * groupCode = ip.readAllSousCategorie(); HashMap<Integer,HashMap<Ingredient,
	 * Integer>> result = new HashMap<Integer,HashMap<Ingredient,Integer>>(); for
	 * (int group : groupCode) {
	 * result.put(group,creatVectorResultByGroupCode(ingredientEntry,group)); }
	 * 
	 * return result;
	 * 
	 * 
	 * }
	 */
	/**
	 * Fonction HeavySide qui active ou non le neuron de la cat�gorie en question en
	 * fonction de son resultat de sortie
	 * 
	 * @param resultCalculSortie
	 * @param groupeCode
	 * @return
	 */

	public boolean HeavySidePerceptron(double resultCalculSortie, int groupeCode) {

		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> listIng = ip.readIngredientsBySousCategorie(groupeCode);
		double size = listIng.size();
		if (resultCalculSortie >= (size / 2)) {
			return true;
		}

		return false;
	}

	public HashMap<Ingredient, Integer> vectorEntry(User user) {

		WeightIngredientPersistence wip = new WeightIngredientPersistence();
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> ing = ip.readAllIngredient();
		HashMap<Ingredient, Integer> entry = new HashMap<Ingredient, Integer>();
		for (Ingredient i : ing) {
			if(wip.readWeightByIdIngredient(i.getId_ingredient(), user)>3) {
				entry.put(i, 1);
			}
			else{
				entry.put(i, 0);
			}
		}
		return entry;
	}
}