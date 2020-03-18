package test;

import business.Ingredient;
import business.SystemUtility;

public class TestSamir {

	public static void main(String[] args) {
		
		Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();
		ingredient.setAlim_nom_fr("concentré tomate");
		System.out.println(ingredient.toString()+"\n");
		ingredient = u.associateIngredient(ingredient);
		System.out.println(ingredient.toString());
		  
		
		
	
	}
	

}
