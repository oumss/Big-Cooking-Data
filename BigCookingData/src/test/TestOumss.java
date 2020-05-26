package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import ingredients.IngredientsToBase;

public class TestOumss {

	public static void main(String[] args) throws IOException {

		//test ingredient to base
		
		IngredientsToBase tobase = new IngredientsToBase();
		Recipe recipe = tobase.getRp().readRecipeById(4235);
		System.out.println(recipe.getTitle());
		System.out.println(recipe.getId());
		System.out.println(recipe.getIngredientsList()+"\n");
		//String ingredientsList = recipe.getIngredientsList();
		
	/*	 
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
		
	}

}
