package business;

import java.util.HashMap;

public class Recipe {

	private int id;
	private String title;
	private String url;
	private int numberOfPerson;
	private String timeCooking;
	private String timeTotal;
	private String ingredientsList;
	private String ustensilsList;
	private int idIngredients;
	private HashMap<Ingredient, Integer> ingredientsMap = new HashMap<Ingredient, Integer>();
	private int budget;
	private String category;
	private int level;
	private String steps;

	public Recipe() {
	}

	public Recipe(int id, String title, String url, int numberOfPerson, String timeCooking, String timeTotal,
			String ingredientsList, String ustensilsList, int idIngredients,
			HashMap<Ingredient, Integer> ingredientsMap, int budget, String category, int level, String steps) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.numberOfPerson = numberOfPerson;
		this.timeCooking = timeCooking;
		this.timeTotal = timeTotal;
		this.ingredientsList = ingredientsList;
		this.ustensilsList = ustensilsList;
		this.idIngredients = idIngredients;
		this.ingredientsMap = ingredientsMap;
		this.budget = budget;
		this.category = category;
		this.level = level;
		this.steps = steps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getTimeCooking() {
		return timeCooking;
	}

	public void setTimeCooking(String timeCooking) {
		this.timeCooking = timeCooking;
	}

	public String getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(String timeTotal) {
		this.timeTotal = timeTotal;
	}

	public String getIngredientsList() {
		return ingredientsList;
	}

	public void setIngredientsList(String ingredientsList) {
		this.ingredientsList = ingredientsList;
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

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public String getUstensilsList() {
		return ustensilsList;
	}

	public void setUstensilsList(String ustensilsList) {
		this.ustensilsList = ustensilsList;
	}

}
