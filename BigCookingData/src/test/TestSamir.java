package test;

import business.Ingredient;
import business.Recipe;
import clean.SystemUtility;
import learn.LearnUtility;


public class TestSamir {

	public static void main(String[] args) {
		
		//Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();/*
		ingredient.setAlim_nom_fr("compote de figues");
		System.out.println(ingredient.toString()+"\n");
		
		//u.transformIngredientName(ingredient);
		//System.out.println(ingredient.toString()+"\n");
		
		ingredient = u.associateIngredient(ingredient);
		System.out.println(ingredient.toString());*/
		  


		/**/
		Recipe r = new Recipe();
		Ingredient a = new Ingredient();
		a.setAlim_nom_fr("poulet");
		Ingredient b = new Ingredient();
		b.setAlim_nom_fr("colin");
		Ingredient c = new Ingredient();
		c.setAlim_nom_fr("Tomate concentr� appertis�");
		
		r.getIngredientsMap().put(a, 1);
		r.getIngredientsMap().put(b, 2);
		r.getIngredientsMap().put(c, 3);
		
		
		System.out.println(r.getIngredientsMap().toString());
		u.associateAllIngredient(r);
		System.out.println(r.getIngredientsMap().toString());
		
		System.out.println("\n\n");
		
		
		
		/*
		Ingredient ooo = new Ingredient();
		ooo.setAlim_nom_fr("compote figue");
		IngredientPersistance ip = new IngredientPersistance();
		System.out.println(ip.readIngredientWithLike(ooo));
	*/
		
		
		//LearnUtility lu = new LearnUtility();
		//lu.initIngredientList();
		//System.out.println(lu.getIngredientChoice().toString());
	}
	

}