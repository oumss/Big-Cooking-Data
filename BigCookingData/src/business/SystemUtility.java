package business;

import java.util.ArrayList;
import java.util.HashMap;

import persistance.IngredientPersistance;

public class SystemUtility {

	private int id;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

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
	
	public Ingredient associateIngredient(Ingredient ingredient) {
		IngredientPersistance ip = new IngredientPersistance();
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
			a = e.getKey() ;
			a = u.associateIngredient(e.getKey());	
		}
	}
	

}
