package ingredients;

import java.util.ArrayList;

import business.Ingredient;
import business.Recipe;
import persistance.IngredientPersistance;
import persistance.IngredientRecipePersistance;
import persistance.RecipePersistance;

public class IngredientsToBase {

	private RecipePersistance rp = new RecipePersistance();
	private IngredientPersistance ip = new IngredientPersistance();
	private IngredientRecipePersistance irp = new IngredientRecipePersistance();
	
	public IngredientsToBase() {
	
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		recipes.addAll(rp.readAllRecipe());
		
		for(Recipe recipe : recipes) {
			String ingerdientString = recipe.getIngredientsList();
			ArrayList<Ingredient> ingredientsList = new ArrayList<Ingredient>();
			ingredientsList.addAll(readIngredientsList(ingerdientString));
			
			
		}
		
		
	}
	
	public ArrayList<Ingredient> readIngredientsList(String ingredientsString) {
		
		
		
		return null;
	}
}
