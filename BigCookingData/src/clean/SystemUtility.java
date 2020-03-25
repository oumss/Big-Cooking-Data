package clean;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import persistance.IngredientPersistance;

public class SystemUtility {

	private int id;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	private ArrayList<String> wordToDelet = new ArrayList<String>();

	public SystemUtility() {
	}

	public String createQuery(String ingredient) {
		String[] query = ingredient.split(" ");
		String result = "SELECT * FROM ingredient where alim_nom_fr like ";
		for (int i = 0; i < query.length; i++) {
			if (i == 0) {
				result = result + "'%" + query[i] + "%'";
			} else if (i > 0 && i <= query.length) {
				result = result + "and alim_nom_fr like '%" + query[i] + "%'";
			} else {
				result = result + "and alim_nom_fr like '%" + query[i] + "%'";
			}
		}
		return result;
	}

	public String createQueryWithOr(String ingredient) {
		String[] query = ingredient.split(" ");
		String result = "SELECT * FROM ingredient where alim_nom_fr like ";
		for (int i = 0; i < query.length; i++) {
			if (i == 0) {
				result = result + "'%" + query[i] + "%'";
			} else if (i > 0 && i <= query.length) {
				result = result + "or alim_nom_fr like '%" + query[i] + "%'";
			} else {
				result = result + "or alim_nom_fr like '%" + query[i] + "%'";
			}
		}
		return result;
	}
	
	public Ingredient associateIngredient(Ingredient ingredient) {
		IngredientPersistance ip = new IngredientPersistance();
		SystemUtility  u = new SystemUtility();
		u.transformIngredientName(ingredient);
		//Ingredient ingredient = new Ingredient(this.poids, this.alim_grp_code, this.alim_ssgrp_code, this.alim_ssssgrp_code, this.alim_nom_fr, this.id_ingredient);
		ArrayList<Ingredient> ingChoice = ip.readIngredientWithLike(ingredient);
		double current = 0;
		double percentage;
		
		for(Ingredient z : ingChoice) {
			percentage = StringSimilarity.similarity(ingredient.getAlim_nom_fr() , z.getAlim_nom_fr());
			if ( current <= (percentage) )  {     
				current = percentage;
				ingredient.setAlim_grp_code(z.getAlim_grp_code());
				ingredient.setAlim_nom_fr(z.getAlim_nom_fr());
				ingredient.setAlim_ssgrp_code(z.getAlim_ssgrp_code());
				ingredient.setAlim_ssssgrp_code(z.getAlim_ssssgrp_code());
				ingredient.setId_ingredient(z.getId_ingredient());
				ingredient.setPoids(z.getPoids());
			}
		}		
		return ingredient;
	}

	public void associateAllIngredient (Recipe recipe) {
		SystemUtility u = new SystemUtility();
		Ingredient a = new Ingredient();
		for(HashMap.Entry<Ingredient,Integer> e : recipe.getIngredientsMap().entrySet() ) {
			a = u.associateIngredient(e.getKey());
			recipe.getIngredientsMap().replace(a,e.getValue());
		}
	}
	
	public void transformIngredientName (Ingredient ingredient) {
		
		this.wordToDelet.add(" à ");
		this.wordToDelet.add(" au ");
		this.wordToDelet.add(" aux ");
		this.wordToDelet.add(" des ");
		this.wordToDelet.add(" de ");
		this.wordToDelet.add(" avec ");
		this.wordToDelet.add(" sans ");
		this.wordToDelet.add(" l'");
		this.wordToDelet.add(" d'");
		this.wordToDelet.add(" en ");
		this.wordToDelet.add(" et ");
		
		for(String word : this.wordToDelet) {
			if (ingredient.getAlim_nom_fr().contains(word)) {
				ingredient.setAlim_nom_fr(ingredient.getAlim_nom_fr().replaceAll(word," "));
			}
		}
		
		String[] query = ingredient.getAlim_nom_fr().split(" ");
		String newWord = new String();
		
		for(int count = 0; count < query.length; count++) {
			query[count] = query[count]+" ";
			if(query[count].contains("s ")) {
				query[count] = query[count].substring(0,query[count].length()-2);
			}
			if(count == 0) {
				newWord = query[count];
			}
			else {
				if(newWord.contains(" ")) {
					newWord = newWord + query[count];
				}
				else {
					newWord = newWord +" "+ query[count];
				}
			}
		}
		ingredient.setAlim_nom_fr(newWord);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}
	
}
