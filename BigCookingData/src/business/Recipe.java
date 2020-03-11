package business;


public class Recipe {

	private int id_recipe;
	private String name;
	private int time; // in minutes
	private int id_ingredient;
	private float price;
	private int weight;
	
	public Recipe() {
		
	}
	
	public Recipe(int id_recipe, String name, int time, int id_ingredient, float price, int weight) {
		super();
		this.id_recipe = id_recipe;
		this.name = name;
		this.time = time;
		this.id_ingredient = id_ingredient;
		this.price = price;
		this.weight = weight;
	}


	public int getId_recipe() {
		return id_recipe;
	}


	public void setId_recipe(int id_recipe) {
		this.id_recipe = id_recipe;
	}


	public int getId_ingredient() {
		return id_ingredient;
	}


	public void setId_ingredient(int id_ingredient) {
		this.id_ingredient = id_ingredient;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
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
