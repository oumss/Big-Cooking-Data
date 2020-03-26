package learn;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import business.User;
import clean.SystemUtility;
import persistance.IngredientPersistance;
import persistance.WeightIngredientPersistence;

public class LearnUtility {
	
	private User user;
	private ArrayList<Ingredient> ingredientChoice =  new ArrayList<Ingredient>();
	

	public LearnUtility() {
		
	}
	
	
	public void initIngredientList (){
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		SystemUtility u = new SystemUtility();
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setAlim_nom_fr("fraise");
		ingredientList.add(ingredient1);
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setAlim_nom_fr("banane");
		ingredientList.add(ingredient2);
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setAlim_nom_fr("Orange");
		ingredientList.add(ingredient3);
		Ingredient ingredient4 = new Ingredient();
		ingredient4.setAlim_nom_fr("mangue");
		ingredientList.add(ingredient4);
		Ingredient ingredient5 = new Ingredient();
		ingredient5.setAlim_nom_fr("asperge");
		ingredientList.add(ingredient5);
		Ingredient ingredient6 = new Ingredient();
		ingredient6.setAlim_nom_fr("poire");
		ingredientList.add(ingredient6);
		Ingredient ingredient7 = new Ingredient();
		ingredient7.setAlim_nom_fr("tomate");
		ingredientList.add(ingredient7);
		Ingredient ingredient8 = new Ingredient();
		ingredient8.setAlim_nom_fr("concombre");
		ingredientList.add(ingredient8);
		Ingredient ingredient9 = new Ingredient();
		ingredient9.setAlim_nom_fr("salade verte");
		ingredientList.add(ingredient9);
		Ingredient ingredient10 = new Ingredient();
		ingredient10.setAlim_nom_fr("cornichons");
		ingredientList.add(ingredient10);
		Ingredient ingredient11 = new Ingredient();
		ingredient11.setAlim_nom_fr("oignon");
		ingredientList.add(ingredient11);
		Ingredient ingredient12 = new Ingredient();
		ingredient12.setAlim_nom_fr("chocolat noir");
		ingredientList.add(ingredient12);
		Ingredient ingredient13 = new Ingredient();
		ingredient13.setAlim_nom_fr("creme dessert au caramel");
		ingredientList.add(ingredient13);
		Ingredient ingredient14 = new Ingredient();
		ingredient14.setAlim_nom_fr("bonbon");
		ingredientList.add(ingredient14);
		Ingredient ingredient15 = new Ingredient();
		ingredient15.setAlim_nom_fr("fondant au chocolat");
		ingredientList.add(ingredient15);
		Ingredient ingredient16 = new Ingredient();
		ingredient16.setAlim_nom_fr("vanille");
		ingredientList.add(ingredient16);
		Ingredient ingredient17 = new Ingredient();
		ingredient17.setAlim_nom_fr("saumon");
		ingredientList.add(ingredient17);
		Ingredient ingredient18 = new Ingredient();
		ingredient18.setAlim_nom_fr("steak de boeuf");
		ingredientList.add(ingredient18);
		Ingredient ingredient19 = new Ingredient();
		ingredient19.setAlim_nom_fr("huitre");
		ingredientList.add(ingredient19);
		Ingredient ingredient20 = new Ingredient();
		ingredient20.setAlim_nom_fr("colin");
		ingredientList.add(ingredient20);
		Ingredient ingredient21 = new Ingredient();
		ingredient21.setAlim_nom_fr("poulet");
		ingredientList.add(ingredient21);
		
		for(Ingredient i : ingredientList) {
			i = u.associateIngredient(i);
			this.ingredientChoice.add(i);
		}
	}
	
	
	public int calculWeightRecipe(Recipe recipe, User user) {
		int weight_recipe = 0;
		WeightIngredientPersistence weight_ingredient = new WeightIngredientPersistence();
		for (HashMap.Entry<Ingredient, Integer> e : recipe.getIngredientsMap().entrySet()) {
			weight_recipe = weight_recipe + weight_ingredient.readWeightByIdIngredient(e.getKey().getId_ingredient(), user);
		}
		return weight_recipe;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Ingredient> getIngredientChoice() {
		return ingredientChoice;
	}

	public void setIngredientChoice(ArrayList<Ingredient> ingredientChoice) {
		this.ingredientChoice = ingredientChoice;
	}

}