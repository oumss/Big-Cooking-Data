package business;

import java.util.ArrayList;

public class Recipe {

	private int id;
	private String name;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Recipe(int id,String name, ArrayList<Ingredient> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
