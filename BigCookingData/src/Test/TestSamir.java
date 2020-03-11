package Test;
import business.*;
import java.util.ArrayList;

import business.Ingredient;
import business.SystemUtility;
import persistance.IngredientPersistance;

public class TestSamir {

	public static void main(String[] args) {
		SystemUtility a = new SystemUtility();
		String b = a.createQuery("mousse au chocolat");
		System.out.println(b);
		
		/*
		ArrayList <Ingredient> m = new ArrayList<Ingredient>();
		IngredientPersistance i = new IngredientPersistance();
		m = i.readIngredientWithLike("mousse au chocolat");
		System.out.println(m);*/
	}

}
