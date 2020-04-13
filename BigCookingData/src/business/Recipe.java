package business;

import java.util.ArrayList;
import java.util.HashMap;

public class Recipe {

	private int id_recipe;
	private String name;
	private String time;
	private int id_ingredient_recipe;
	private HashMap<Ingredient, Integer> ingredientsMap = new HashMap<Ingredient, Integer>();
	private int price;
	private String category;
	private int difficutly;
	private String steps;
	public ArrayList<Integer> coordonnees = new ArrayList<Integer>();

	public Recipe() {
	}

	public Recipe(int id_recipe, String name, String time, int id_ingredient_recipe, int price, String category,
			int difficutly, String steps) {
		super();
		this.id_recipe = id_recipe;
		this.name = name;
		this.time = time;
		this.id_ingredient_recipe = id_ingredient_recipe;
		this.price = price;
		this.category = category;
		this.difficutly = difficutly;
		this.steps = steps;
	}

	public int getId_recipe() {
		return id_recipe;
	}

	public void setId_recipe(int id_recipe) {
		this.id_recipe = id_recipe;
	}

	public int getId_ingredient_recipe() {
		return id_ingredient_recipe;
	}

	public void setId_ingredient_recipe(int id_ingredient_recipe) {
		this.id_ingredient_recipe = id_ingredient_recipe;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDifficutly() {
		return difficutly;
	}

	public void setDifficutly(int difficutly) {
		this.difficutly = difficutly;
	}

	public HashMap<Ingredient, Integer> getIngredientsMap() {
		return ingredientsMap;
	}

	public void setIngredientsMap(HashMap<Ingredient, Integer> ingredientsMap) {
		this.ingredientsMap = ingredientsMap;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

}
