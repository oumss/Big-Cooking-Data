package test;

import java.util.ArrayList;

import business.Ingredient;
import business.Recipe;
import clean.SystemUtility;
import learn.FirstPerceptronEntry;
import learn.LearnUtility;
import learn.PerceptronUtility;
import persistance.IngredientPersistance;


public class TestSamir {

	public static void main(String[] args) {
		
		//Ingredient ingredient = new Ingredient();
		//SystemUtility u = new SystemUtility();
		/*ingredient.setAlim_nom_fr("compote de figues");
		System.out.println(ingredient.toString()+"\n");
		
		//u.transformIngredientName(ingredient);
		//System.out.println(ingredient.toString()+"\n");
		
		ingredient = u.associateIngredient(ingredient);
		System.out.println(ingredient.toString());*/
		  


		/*
		Recipe r = new Recipe();
		Ingredient a = new Ingredient();
		a.setAlim_nom_fr("poulet");
		Ingredient b = new Ingredient();
		b.setAlim_nom_fr("colin");
		Ingredient c = new Ingredient();
		c.setAlim_nom_fr("Tomate concentré appertisé");
		
		r.getIngredientsMap().put(a, 1);
		r.getIngredientsMap().put(b, 2);
		r.getIngredientsMap().put(c, 3);
		
		
		System.out.println(r.getIngredientsMap().toString());
		u.associateAllIngredient(r);
		System.out.println(r.getIngredientsMap().toString());
		
		System.out.println("\n\n");
		
		*/
		
		/*
		Ingredient ooo = new Ingredient();
		ooo.setAlim_nom_fr("compote figue");
		IngredientPersistance ip = new IngredientPersistance();
		System.out.println(ip.readIngredientWithLike(ooo));
	*/
		
		
		//LearnUtility lu = new LearnUtility();
		//lu.initIngredientList();
		//System.out.println(lu.getIngredientChoice().toString());
		/*
		FirstPerceptronEntry fpe = new FirstPerceptronEntry();
		
		PerceptronUtility pu = new PerceptronUtility();
		
		pu.initiIngredienttEntry(fpe);
		*/
		
		/*
		IngredientPersistance ingp = new IngredientPersistance();
		System.out.println(ingp.readAllSousCategorie());
		System.out.println(ingp.readAllSousCategorie().size());
		
		
		System.out.println("\n");
		
		System.out.println(ingp.readIngredientsBySousCategorie(205));
		System.out.println(ingp.readIngredientsBySousCategorie(205).size());
		*/
		//PerceptronUtility percepu = new PerceptronUtility();
				
		
		//percepu.creatAllResultVectorByGroup();
		
		
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> listIng = ip.readIngredientsBySousCategorie(204);
		System.out.println(listIng.size()/5);
		System.out.println("\n");
		/*ArrayList<Ingredient> listIng2 = ip.readIngredientsBySousCategorie(40);
		ArrayList<Ingredient> listIng3 = ip.readIngredientsBySousCategorie(602);
		ArrayList<Ingredient> listIng4 = ip.readIngredientsBySousCategorie(803);
		
		
		System.out.println(listIng2.size()/5);
		System.out.println("\n");
		System.out.println(listIng3.size()/5);
		System.out.println("\n");
		System.out.println(listIng4.size()/5);
		System.out.println("\n");*/
		
		
		PerceptronUtility puti = new PerceptronUtility();
		
		System.out.println(puti.HeavySidePerceptron(18, 204));
		
		
		
		
	
	}
	

}
