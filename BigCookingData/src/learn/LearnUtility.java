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
	

	public LearnUtility(User user) {
		this.user = user;
	}
	
	public ArrayList<String> proposeTaste (){
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<String> categorie = ip.readAllSousCategorieNames();
		return categorie;
	}

}