package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import ingredients.IngredientsToBase;
import learnByPerceptron.PerceptronUtility;
import persistance.RecipePersistance;

public class TestOumss {

	public static void main(String[] args) throws IOException {

		//test ingredient to base
	/*		
		IngredientsToBase tobase = new IngredientsToBase();
		Recipe recipe = tobase.getRp().readRecipeById(4235);
		System.out.println(recipe.getTitle());
		System.out.println(recipe.getId());
		System.out.println(recipe.getIngredientsList()+"\n");
		//String ingredientsList = recipe.getIngredientsList();
		
	 
		HashMap<String, String> quantityMap = new HashMap<String, String>();
		ArrayList<Ingredient> ingredientsAssociated = new ArrayList<Ingredient>();
		ArrayList<String> ingredientsList = new ArrayList<String>();
		String ingredientString ="";
		ingredientString = recipe.getIngredientsList();
		HashMap<String, String> nameMap = new HashMap<String, String>();
		nameMap = tobase.readIngredientsList(ingredientString);
		
		if (!(nameMap.equals(null))) {
			for (String key : nameMap.keySet()) {
				String value = nameMap.get(key);
				String[] partValue = value.split(" ");
				String quantity;
				if (partValue.length != 0) {
					quantity = partValue[0];
				} else {
					quantity = "";
				}
				quantityMap.put(key, quantity);
			}
			for (String key : nameMap.keySet()) {
				Ingredient ingredientKey = new Ingredient();
				ingredientKey.setAlim_nom_fr(key);
				ingredientsList.add(key);
				Ingredient ingredient = tobase.getSu().associateIngredient(ingredientKey);
				ingredientsAssociated.add(ingredient);
				
			}
		}
	*/
		
		
		PerceptronUtility pu = new PerceptronUtility();
		RecipePersistance rp = new RecipePersistance();
		
		System.out.println("salé fruitn de mer");
		Recipe recipe1 = rp.readRecipeById(12312);
		System.out.println(pu.calculateTaux(recipe1));
		
		System.out.println("sucre normal");
		Recipe recipe = rp.readRecipeById(12311);
		System.out.println(pu.calculateTaux(recipe));
		
		System.out.println("sucre tarte amandine aux noix chocolat ");
		Recipe recipe2 = rp.readRecipeById(171);
		System.out.println(pu.calculateTaux(recipe2));
		
	}

}
