package Test;
import business.*;
import java.util.ArrayList;

import persistance.IngredientPersistance;

public class TestSamir {

	public static void main(String[] args) {
		
		Ingredient ingredient = new Ingredient();
		ingredient.setAlim_nom_fr("concentré tomate");
		System.out.println(ingredient.toString()+"\n");
		ingredient.associateIngredient();
		System.out.println(ingredient.toString());
		
		
	
	}
	

}
