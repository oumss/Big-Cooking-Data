package core;

import java.util.ArrayList;

import business.Ingredient;

public class SearchRecipe {

	private ArrayList<Ingredient> ingredients;
	private String keyword;
	
	
	public SearchRecipe() {
	}

	public SearchRecipe(ArrayList<Ingredient> ingredients, String keyword) {
		super();
		this.ingredients = ingredients;
		this.keyword = keyword;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
