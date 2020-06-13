package testLearnPerceptron;

import java.util.HashMap;
import java.util.Random;

import business.Ingredient;
import business.Recipe;
import persistance.IngredientPersistance;
import persistance.IngredientRecipePersistance;
import persistance.WeightPerceptronPersistence;

public class PerceptronUtility {

	IngredientPersistance ip = new IngredientPersistance();
	IngredientRecipePersistance irp = new IngredientRecipePersistance();

	public HashMap<String, Float> calculateTaux(Recipe recipe, int entryRecipe) {

		HashMap<String, Float> tauxTotal = new HashMap<String, Float>();
		initTauxMap(tauxTotal, entryRecipe);
		HashMap<Ingredient, Integer> ingredients = recipe.getIngredientsMap();
		HashMap<String, Float> tauxIngredient = new HashMap<String, Float>();

		for (Ingredient ingredient : ingredients.keySet()) {

			tauxIngredient = ip.getTauxbis(ingredient.getId_ingredient());
			int quantity = ingredients.get(ingredient);
			String ingredientList = irp.readIngredientList(recipe.getId(), ingredient.getId_ingredient());
			HashMap<String, Float> tauxElement = new HashMap<String, Float>();

			for (String element : tauxIngredient.keySet()) {
				float taux = tauxIngredient.get(element);
				float newTaux = 0;
				//if(taux == null) {
					
				//}
				if (quantity > 10) {
					newTaux = (quantity / 100) * taux;
				} else {
					if ((ingredientList.contains(" l ")) || (ingredientList.contains(" kg "))) {
						newTaux = (quantity * 10) * taux;
					} else {
						newTaux = quantity * taux;
					}
				}
				tauxElement.put(element, newTaux);
				float i =  tauxTotal.get(element) + newTaux;
				tauxTotal.put(element,i);
			}
		}

		return tauxTotal;

	}

	public void initTauxMap(HashMap<String, Float> map, int entryRecipe) {
		
		if (entryRecipe == 1) {
			map.put("Sucres (g/100g)", (float) 10);
			map.put("Sel chlorure de sodium (g/100g)", (float) 10);
		} 
		else {
			map.put("Sucres (g/100g)", (float) -10);
			map.put("Sel chlorure de sodium (g/100g)", (float) -10);
		}

	}

	public float newWeight(float entry, float weight, float pasApp, float sortie, float sortieD) {
		return weight + pasApp * (sortieD - sortie) * entry;
	}

	public int calculSortiePerceptron(HashMap<String, Float> parameterEntry, HashMap<String, Float> weight) {
		float result = 0;
		for (String mapPerEntry : parameterEntry.keySet()) {
			result = result + (parameterEntry.get(mapPerEntry) * weight.get(mapPerEntry));
		}
		
		if (result >= 0) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public boolean acceptSortie(HashMap<String, Float> parameterEntry, HashMap<String, Float> weight, int sortieD) {
		if (calculSortiePerceptron(parameterEntry, weight) >= 0 && sortieD == 1) {
			return true;
		} else if (calculSortiePerceptron(parameterEntry, weight) < 0 && sortieD == -1) {
			return true;
		} else if (calculSortiePerceptron(parameterEntry, weight) >= 0 && sortieD == -1) {
			return false;
		} else if (calculSortiePerceptron(parameterEntry, weight) < 0 && sortieD == 1) {
			return false;
		}

		return false;
	}

	public void initiWeightEntry(int id_user) {
		HashMap<String, Float> parameterEntry = new HashMap<String, Float>();
		parameterEntry.put("Eau (g/100g)", (float) 1 );
		parameterEntry.put("Sucres (g/100g)", (float) 1 );
		parameterEntry.put("Sel chlorure de sodium (g/100g)", (float) 1 );
		parameterEntry.put("Proteines (g/100g)", (float) 1 );
		parameterEntry.put("Glucides (g/100g)", (float) 1 );
		parameterEntry.put("Lipides (g/100g)", (float) 1 );
		parameterEntry.put("W0", (float) 1 );

		HashMap<String, Float> weightEntry = new HashMap<String, Float>();
		for (String parameter : parameterEntry.keySet()) {

			float start = 0;
			float end = 10;
			double random = new Random().nextDouble();
			float result = (float) (start + (random * (end - start)));

			weightEntry.put(parameter, result);

		}

		WeightPerceptronPersistence wpp = new WeightPerceptronPersistence();
		wpp.insertWeight(id_user, weightEntry);
	}
}