package test;

import business.Ingredient;
import business.SystemUtility;

public class TestSamir {

	public static void main(String[] args) {
		
		Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();
		ingredient.setAlim_nom_fr("concentrés de tomates au fruit de chips carottes avec de l'ailes avec des comcombres aux cerises sans poulets et de l'huile d'olives");
		System.out.println(ingredient.toString()+"\n");
		
		u.transformIngredientName(ingredient);
		System.out.println(ingredient.toString()+"\n");
		
		ingredient = u.associateIngredient(ingredient);
		System.out.println(ingredient.toString());
		  
	
	}
	

}
