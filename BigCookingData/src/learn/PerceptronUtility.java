package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.apache.bcel.generic.INVOKEVIRTUAL;

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

	public boolean acceptSortie(int entry, double weight, int sortieD) {
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

	
	/**
	 * Fonction qui crée une liste qui pour chaque groupe, crée le vecteur d'ingredient de ce groupe 
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
	 * Fonction qui crée le vecteur de resultat attendu pour une seule catégorie
	 * @param groupeCode
	 * @return
	 */
	public HashMap<Ingredient, Integer> creatVectorResultByGroupCode(int groupeCode) {

		IngredientPersistance ip = new IngredientPersistance();

		ArrayList<Ingredient> ingredients = ip.readAllIngredient();

		HashMap<Ingredient, Integer> a = new HashMap<Ingredient, Integer>();

		for (Ingredient ing : ingredients) {
			if (ing.getAlim_ssgrp_code() == groupeCode) {
				a.put(ing, 1);

			} else {
				a.put(ing, 0);
			}
		}

		return a;

	}
	
	/**
	 * Fonction qui crée les vecteurs de resultat attendu pour chaque catégories
	 * @return
	 */
	public HashMap<Integer,HashMap<Ingredient, Integer>> creatAllResultVectorByGroup() {
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Integer> groupCode = ip.readAllSousCategorie();
		HashMap<Integer,HashMap<Ingredient, Integer>> result = new HashMap<Integer,HashMap<Ingredient,Integer>>();
		for (int group : groupCode) {
			result.put(group,creatVectorResultByGroupCode(group));
		}
		
		return result;


	}
	
	/**
	 * Fonction HeavySide qui active ou non le neuron de la catégorie en question en fonction de son resultat de sortie
	 * @param resultCalculSortie
	 * @param groupeCode
	 * @return
	 */
	
	public boolean HeavySidePerceptron (double resultCalculSortie, int groupeCode) {

		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> listIng = ip.readIngredientsBySousCategorie(groupeCode);
		
		if (resultCalculSortie >= (listIng.size()/5)) {
			return true;
		}
		
		
		return false;
	}
}