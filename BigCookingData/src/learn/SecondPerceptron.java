package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import business.Ingredient;
import business.Recipe;
import persistance.IngredientPersistance;
import persistance.IngredientRecipePersistance;
import persistance.RecipePersistance;

public class SecondPerceptron {

	private SecondPerceptronEntry spe = new SecondPerceptronEntry();

	public SecondPerceptron() {
	}

	public SecondPerceptron(SecondPerceptronEntry spe) {
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
		ArrayList<Integer> listrecipe = new ArrayList<Integer>();
		IngredientRecipePersistance irp = new IngredientRecipePersistance();
		for (Ingredient ing : listing) {
			/*
			 * Utiliser la fonction qui nous retourne l'id de plusieurs recettes par rapport
			 * � l'id d'un ingredient (prendre l'id de l'ingredient ing) dans
			 * IngredientRecipePresistance.java Et mettre toutes les id trouv�e dans une
			 * listrecipe
			 */
			ArrayList<Integer> listId = new ArrayList<Integer>();
			listId.addAll(getIdRecipeList(irp.readRecipesByIdIngredient(ing.getId_ingredient())));
			listrecipe.addAll(listId);
		}
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int id_recipe : listrecipe) {
			result.add(rp.readRecipeById(id_recipe));
		}
		return result;
	}

	public ArrayList<Integer> getIdRecipeList(ArrayList<Recipe> recipes) {
		ArrayList<Integer> listId = new ArrayList<Integer>();
		for (Recipe recipe : recipes) {
			int id = recipe.getId();
			listId.add(id);
		}
		return listId;
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
		IngredientRecipePersistance irp = new IngredientRecipePersistance();
		ArrayList<Integer> listrecipe = new ArrayList<Integer>();
		for (Ingredient ing : listing) {
			/*
			 * Utiliser la fonction qui nous retourne l'id de plusieurs recettes par rapport
			 * � l'id d'un ingredient (prendre l'id de l'ingredient ing) dans
			 * IngredientRecipePresistance.java Et mettre toutes les id trouv�e dans une
			 * listrecipe
			 */
			ArrayList<Integer> listId = new ArrayList<Integer>();
			listId.addAll(getIdRecipeList(irp.readRecipesByIdIngredient(ing.getId_ingredient())));
			listrecipe.addAll(listId);
		}
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int id_recipe : listrecipe) {

			result.add(rp.readRecipeById(id_recipe));
		}

		return result;
	}

}
