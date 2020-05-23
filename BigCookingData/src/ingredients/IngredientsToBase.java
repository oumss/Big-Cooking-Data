package ingredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import business.Ingredient;
import business.Recipe;
import clean.SystemUtility;
import persistance.IngredientPersistance;
import persistance.IngredientRecipePersistance;
import persistance.RecipePersistance;

public class IngredientsToBase {

	private RecipePersistance rp = new RecipePersistance();
	private IngredientRecipePersistance irp = new IngredientRecipePersistance();
	private SystemUtility su = new SystemUtility();

	/**
	 * Fonction principal pour la mise en base des ingredients d'une recette
	 */
	public IngredientsToBase() {

		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		recipes.addAll(rp.readAllRecipe());

		for (Recipe recipe : recipes) {
			HashMap<String, String> quantityMap = new HashMap<String, String>();
			ArrayList<Ingredient> ingredientsAssociated = new ArrayList<Ingredient>();
			ArrayList<String> ingredientsList = new ArrayList<String>();
			String ingredientString = recipe.getIngredientsList();
			HashMap<String, String> nameMap = readIngredientsList(ingredientString);

			for (String key : nameMap.keySet()) {
				String value = nameMap.get(key);
				String[] partValue = value.split(" ");
				String quantity;
				if (partValue[0] != null) {
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
				Ingredient ingredient = su.associateIngredient(ingredientKey);
				ingredientsAssociated.add(ingredient);

			}
			irp.addIngredientsRecipe(recipe, nameMap, ingredientsAssociated, ingredientsList, quantityMap);
		}
	}

	public HashMap<String, String> readIngredientsList(String ingredientsList) {

		HashMap<String, String> ingredientMap = new HashMap<String, String>();
		String[] line = ingredientsList.split("},");
		for (int index = 0; index < line.length; index++) {
			String[] partLine = line[index].split(",");
			String prefix = "";
			String name = "";
			String complement = "";
			String quantity = "";
			for (int index2 = 0; index2 < partLine.length; index2++) {
				String[] part = partLine[index2].split("\"");

				if (partLine[index2].contains("prefix")) {
					prefix = part[3];
				}
				if (partLine[index2].contains("complement")) {
					complement = part[3];
				}
				if (partLine[index2].contains("quantity")) {
					quantity = part[3];
				}
				if (partLine[index2].contains("name")) {
					name = part[3];
				} else {
					continue;
				}

			}
			String res = quantity + " " + prefix + " " + name + " " + complement;
			ingredientMap.put(name, res);
		}
		return ingredientMap;
	}

	public RecipePersistance getRp() {
		return rp;
	}

	public void setRp(RecipePersistance rp) {
		this.rp = rp;
	}

	public IngredientRecipePersistance getIrp() {
		return irp;
	}

	public void setIrp(IngredientRecipePersistance irp) {
		this.irp = irp;
	}

	public SystemUtility getSu() {
		return su;
	}

	public void setSu(SystemUtility su) {
		this.su = su;
	}

}
