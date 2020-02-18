package business;

import java.util.ArrayList;

public class System {

	private int id;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public System() {
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
