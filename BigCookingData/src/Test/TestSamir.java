package Test;
import business.*;
import java.util.ArrayList;

import business.Ingredient;
import business.SystemUtility;
import persistance.IngredientPersistance;

public class TestSamir {

	public static void main(String[] args) {
		
		Ingredient ingredient = new Ingredient();
		ingredient.setAlim_nom_fr("pomme de terre");
		Ingredient a = ingredient.associateIngredient(ingredient);
		
		System.out.println(a.getAlim_nom_fr());
		
		
		
	}   
		

	
	

}
