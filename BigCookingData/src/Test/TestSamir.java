package Test;
import business.*;
import java.util.ArrayList;

import business.Ingredient;
import business.SystemUtility;
import persistance.IngredientPersistance;

public class TestSamir {

	public static void main(String[] args) {
		/**/SystemUtility a = new SystemUtility();
		Ingredient ingredient = new Ingredient();
		ingredient.setAlim_nom_fr("mousse au chocolat");
		a.associateIngredient(ingredient);
		
		
		
		
		ArrayList <Ingredient> m = new ArrayList<Ingredient>();
		IngredientPersistance i = new IngredientPersistance();
		Ingredient p = new Ingredient();
		p.setAlim_nom_fr("mousse au chocolat");
		m = i.readIngredientWithLike(p);
		System.out.println(m);
		
		
		/*
		String mot1 = "pomme de terre";
		String mot2 = "Pomme de terre   ";
		String mot3 = "Pomme de terre       ";
		String mot4 = "pomme de terre   ";
		String mot5 = "pomme de terre           ";
		String mot6 = "pomme de terre                    ";
		String mot7 = "pomme de terre               ";
		String mot8 = "pomme de terre ";
		String mot9 = "pomme de terre                            ";
		String mot10 = "pomme de terre                                ";
		
		
		
		System.out.println("compare mot2 : " +mot1.compareToIgnoreCase(mot2));
		System.out.println("compare mot3 : " +mot1.compareToIgnoreCase(mot3));
		System.out.println("compare mot4 : " +mot1.compareToIgnoreCase(mot4));
		System.out.println("compare mot5 : " +mot1.compareToIgnoreCase(mot5));
		System.out.println("compare mot6 : " +mot1.compareToIgnoreCase(mot6));
		System.out.println("compare mot7 : " +mot1.compareToIgnoreCase(mot7));
		System.out.println("compare mot8 : " +mot1.compareToIgnoreCase(mot8));
		System.out.println("compare mot9 : " +mot1.compareToIgnoreCase(mot9));
		System.out.println("compare mot10 : " +mot1.compareToIgnoreCase(mot10));*/
	}   
		

	
	

}
