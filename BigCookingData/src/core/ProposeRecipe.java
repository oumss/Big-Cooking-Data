package core;

import java.util.ArrayList;
import business.Ingredient;
import business.Recipe;
import business.User;

public class ProposeRecipe {

	private User user;
	private ArrayList<Ingredient> tastes;
	private ArrayList<Recipe> recipes;
	
	
	public ProposeRecipe() {
	}

	public ProposeRecipe(User user, ArrayList<Ingredient> tastes, ArrayList<Recipe> recipes) {
		super();
		this.user = user;
		this.tastes = tastes;
		this.recipes = recipes;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Ingredient> getTastes() {
		return tastes;
	}

	public void setTastes(ArrayList<Ingredient> tastes) {
		this.tastes = tastes;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}
	
}
