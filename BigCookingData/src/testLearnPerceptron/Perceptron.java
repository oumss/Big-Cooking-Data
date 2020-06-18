package testLearnPerceptron;

import java.util.ArrayList;
import java.util.HashMap;

import business.Recipe;
import persistance.DislikedRecipePersistence;
import persistance.IngredientRecipePersistance;
import persistance.LikedRecipePersistence;
import persistance.RecipePersistance;
import persistance.WeightPerceptronPersistence;

public class Perceptron {

	PerceptronUtility pu = new PerceptronUtility();

	public void apprentissage (int id_user) {

		WeightPerceptronPersistence wpp = new WeightPerceptronPersistence();
		LikedRecipePersistence lrp = new LikedRecipePersistence();
		DislikedRecipePersistence drp = new DislikedRecipePersistence();
		RecipePersistance rp = new RecipePersistance();

		ArrayList<Integer> liked_recipes = lrp.readRecipesByIdUser(id_user);
		ArrayList<Integer> disliked_recipes = drp.readRecipesByIdUser(id_user);

		HashMap<Integer, Integer> entry = initEntry(liked_recipes, disliked_recipes);

		if (!wpp.existWeight(id_user)) {
			pu.initiWeightEntry(id_user);
		}

			boolean changementPoid = false;

			majPercep(entry, rp, changementPoid, id_user, wpp);

	}
	
	
	
	public ArrayList<Recipe> proposition(int id_user){
		
		RecipePersistance rp = new RecipePersistance();
		PerceptronUtility pu = new PerceptronUtility();
		WeightPerceptronPersistence wpp = new WeightPerceptronPersistence();
		ArrayList<Recipe> listRecipe = rp.readAllFirstsRecipe();
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		if (!wpp.existWeight(id_user)) {
			pu.initiWeightEntry(id_user);
		}
		for (int i = 0; i < 1000; i++) {
			Recipe r = listRecipe.get(i);
			
			if(pu.calculSortiePerceptron(pu.calculateTaux(r,1), wpp.getWeight(id_user)) >= 0) {
				result.add(r);
				//System.out.println(r.getTitle() + r.getId());
			}
			
		}
		System.out.println(result.size());
		return result;
	}
	
	
	 
	

	public void majPercep(HashMap<Integer, Integer> entry, RecipePersistance rp, boolean changementPoid, int id_user,WeightPerceptronPersistence wpp) {
		ArrayList<Integer> total = new ArrayList<Integer>();
		int limit = 0;
		while (total.size() != entry.size() && limit < 200) {
			for (int id_recipe : entry.keySet()) {
				
				System.out.println(id_recipe);

				HashMap<String, Float> entryRecipe = pu.calculateTaux(rp.readRecipeById(id_recipe), entry.get(id_recipe));

				int test_break = 0;
				while (changementPoid != true) {
					float epsilon = pu.calculSortiePerceptron(entryRecipe, wpp.getWeight(id_user));

					if (!pu.acceptSortie(entryRecipe, wpp.getWeight(id_user), entry.get(id_recipe))) {
						for (String parameter : wpp.getWeightbis(id_user).keySet()) {
							wpp.updateWeight(parameter, pu.newWeight(entryRecipe.get(parameter), wpp.getUniqueWeight(parameter, id_user), (float) 0.1, epsilon, entry.get(id_recipe)), id_user);
						}

						test_break++;
					}

					else {
						changementPoid = true;

					}

				}
				changementPoid = false;
				if (test_break > 0) {
					
					for (int curseur = 0; curseur < total.size() ; curseur++) {
						total.remove(curseur);	
					}
					
					break;
				}

				else {
					if (!total.contains(id_recipe)) {
						total.add(id_recipe);
					}
				}

			}
			limit++;
		}
		System.out.println("LIMITE= "+limit);
	}

	
	
	public HashMap<Integer, Integer> initEntry( ArrayList<Integer> liked_recipes, ArrayList<Integer> disliked_recipes ){
		HashMap<Integer, Integer> entry = new HashMap<Integer, Integer>();
		for (int i : liked_recipes) {
			entry.put(i, 1);
		}

		for (int i : disliked_recipes) {
			entry.put(i, -1);
		}
		return entry;
	
	}



}
