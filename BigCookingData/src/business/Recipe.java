package business;

import java.util.ArrayList;

public class Recipe {

	private int id;
	private String name;
	private int time; //in minutes
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Recipe(int id,String name, ArrayList<Ingredient> ingredients,int time) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.time = time;
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
		
}
