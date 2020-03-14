package Test;
import business.*;
import java.util.ArrayList;

import persistance.IngredientPersistance;

public class TestSamir {

	public static void main(String[] args) {
		
		Ingredient ingredient = new Ingredient();
		ingredient.setAlim_nom_fr("mousse chocolat");
		System.out.println(ingredient.toString()+"\n");
		ingredient.associateIngredient();
		System.out.println(ingredient.toString());
		
		System.out.println("\n\n");
		System.out.println(StringSimilarity.similarity("mousse au chocolat", "Préparation pour mousse au chocolat"));
		System.out.println(StringSimilarity.similarity("mousse au chocolat", "sauce au chocolat"));
		
	
	}
	

}
