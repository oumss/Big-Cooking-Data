package learn;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import persistance.IngredientPersistance;
import persistance.RecipePersistance;

public class SecondPerceptron {

	private SecondPerceptronEntry spe = new SecondPerceptronEntry();

	public SecondPerceptron() {
		super();
	}

	public SecondPerceptron(SecondPerceptronEntry spe) {
		super();
		this.spe = spe;
	}

	public ArrayList<Recipe> resultPercep() {
		IngredientPersistance ip = new IngredientPersistance();
		RecipePersistance rp = new RecipePersistance();
		HashMap<Integer, Boolean> resultFirst = spe.getFirstPhase().resultAllPerceptron();
		ArrayList<Ingredient> listing = new ArrayList<Ingredient>();
		// System.out.println(resultFirst);
		for (Integer i : resultFirst.keySet()) {
			if (resultFirst.get(i)) {
				listing = ip.readIngredientsBySousCategorie(i);
			}
		}
		// System.out.println(listing.size());
		ArrayList<Integer> listrecipe = new ArrayList();
		for (Ingredient ing : listing) {
			/*
			 * Utiliser la fonction qui nous retourne l'id de plusieurs recettes par rapport
			 * à l'id d'un ingredient (prendre l'id de l'ingredient ing) dans
			 * IngredientRecipePresistance.java
			 * 
			 * Et mettre toutes les id trouvée dans une listrecipe
			 * 
			 * 
			 */
		}
		ArrayList<Recipe> result = new ArrayList();
		for (int id_recipe : listrecipe) {

			result.add(rp.readRecipeById(id_recipe));
		}

		return result;
	}

	public ArrayList<Recipe> resultPercepInit(HashMap<Integer, Boolean> entry) {
		IngredientPersistance ip = new IngredientPersistance();
		RecipePersistance rp = new RecipePersistance();
		HashMap<Integer, Boolean> resultFirst = entry;
		ArrayList<Ingredient> listing = new ArrayList<Ingredient>();
		// System.out.println(resultFirst);
		for (Integer i : resultFirst.keySet()) {
			if (resultFirst.get(i)) {
				listing = ip.readIngredientsBySousCategorie(i);
			}
		}
		// System.out.println(listing.size());
		ArrayList<Integer> listrecipe = new ArrayList();
		for (Ingredient ing : listing) {
			/*
			 * Utiliser la fonction qui nous retourne l'id de plusieurs recettes par rapport
			 * à l'id d'un ingredient (prendre l'id de l'ingredient ing) dans
			 * IngredientRecipePresistance.java
			 * 
			 * Et mettre toutes les id trouvée dans une listrecipe
			 * 
			 * 
			 */
		}
		ArrayList<Recipe> result = new ArrayList();
		for (int id_recipe : listrecipe) {

			result.add(rp.readRecipeById(id_recipe));
		}

		return result;
	}

}
