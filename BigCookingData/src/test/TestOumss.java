package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import ingredients.IngredientsToBase;
import testLearnPerceptron.Perceptron;
import testLearnPerceptron.PerceptronUtility;
import persistance.DislikedRecipePersistence;
import persistance.LikedRecipePersistence;
import persistance.RecipePersistance;

public class TestOumss {

	public static void main(String[] args) throws IOException {

		
		
		LikedRecipePersistence lrp = new LikedRecipePersistence();
		DislikedRecipePersistence drp = new DislikedRecipePersistence();
		
		lrp.addRecipe(12, 2);
		lrp.addRecipe(12, 16);
		lrp.addRecipe(12, 153);
		lrp.addRecipe(12, 164);
		lrp.addRecipe(12, 168);
		lrp.addRecipe(12, 182);
		lrp.addRecipe(12, 742);
		lrp.addRecipe(12, 2653);
		lrp.addRecipe(12, 2193);
		lrp.addRecipe(12, 3812);
		lrp.addRecipe(12, 9549);
		lrp.addRecipe(12, 9578);
		
		drp.addRecipe(12, 6);
		drp.addRecipe(12, 42);
		drp.addRecipe(12, 24);
		drp.addRecipe(12, 1528);
		drp.addRecipe(12, 72208);
		drp.addRecipe(12, 30);
		drp.addRecipe(12, 13768);
		drp.addRecipe(12, 4828);
		drp.addRecipe(12, 1433);
		drp.addRecipe(12, 11489);
		drp.addRecipe(12, 2192);
		drp.addRecipe(12, 25262);
		
		
		//12 	4.47374 	7.14957 	4.50129 	6.88384 	8.75135 	4.00341 	2.11002
		
		//12 	-276.889 	1349.01 	-441.302 	-154.222 	552.516 	-323.093 	1.51002

		Perceptron p = new Perceptron();
		//p.getPu().initiWeightEntry(12);
		
		//p.apprentissage(2);
		
		
		//System.out.println(p.proposition(2));
		
		
		
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
		
	/*	
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
	*/	
	}

}
