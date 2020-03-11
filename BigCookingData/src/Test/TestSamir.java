package Test;
import business.*;
import java.util.ArrayList;

import business.Ingredient;
import business.SystemUtility;
import persistance.IngredientPersistance;

public class TestSamir {

	public static void main(String[] args) {
		SystemUtility a = new SystemUtility();
		/*String b = a.createQuery("Oignon rouge");
		System.out.println(b);*/
		
		
		ArrayList <Ingredient> m = new ArrayList<Ingredient>();
		IngredientPersistance i = new IngredientPersistance();
		Ingredient p = new Ingredient();
		p.setAlim_nom_fr("mousse au chocolat");
		m = i.readIngredientWithLike(p);
		System.out.println(m);/**/
	}

}
