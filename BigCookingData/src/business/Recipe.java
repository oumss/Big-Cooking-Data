package business;

import java.util.HashMap;

public class Recipe {

	private int id;
	private String name;
	private String time;
	private int idIngredients;
	private HashMap<Ingredient, Integer> ingredientsMap = new HashMap<Ingredient, Integer>();
	private int price;
	private String category;
	private int difficutly;
	private String steps;

	public Recipe() {
	}

	public Recipe(int id, String name, String time, int idIngredients, int price, String category, int difficutly,String steps) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.idIngredients = idIngredients;
		this.price = price;
		this.category = category;
		this.difficutly = difficutly;
		this.steps = steps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIdIngredients() {
		return idIngredients;
	}

	public void setIdIngredients(int idIngredients) {
		this.idIngredients = idIngredients;
	}

	public HashMap<Ingredient, Integer> getIngredientsMap() {
		return ingredientsMap;
	}

	public void setIngredientsMap(HashMap<Ingredient, Integer> ingredientsMap) {
		this.ingredientsMap = ingredientsMap;
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

	public int getDifficutly() {
		return difficutly;
	}

	public void setDifficutly(int difficutly) {
		this.difficutly = difficutly;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

}
