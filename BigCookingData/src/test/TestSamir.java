package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import business.Ingredient;
import clean.SystemUtility;
import ingredients.Cleaner;
import learn.FirstPerceptron;
import learn.FirstPerceptronEntry;
import learn.PerceptronUtility;
import learn.SecondPerceptron;
import learn.SecondPerceptronEntry;
import persistance.IngredientPersistance;
import persistance.IngredientRecipePersistance;
import persistance.RecipePersistance;


public class TestSamir {

	public static void main(String[] args) {
		
		/*Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();
		ingredient.setAlim_nom_fr("chou-fleur");
		//System.out.println(ingredient.toString()+"\n");
		//System.out.println("Ingrédient à comparer : tomate");
		System.out.println(ingredient);
		//u.transformIngredientName(ingredient);
		//System.out.println(ingredient.toString()+"\n");
		/**/
		//ingredient = u.associateIngredient(ingredient);
		
		//System.out.println(ingredient);
		//System.out.println(ingredient.toString());/**/
		 /*


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
		
		
		//IngredientPersistance ip = new IngredientPersistance();
		/*System.out.println(listIng.size()/5);
		System.out.println("\n");*/
		/*ArrayList<Ingredient> listIng2 = ip.readIngredientsBySousCategorie(40);
		ArrayList<Ingredient> listIng3 = ip.readIngredientsBySousCategorie(602);
		ArrayList<Ingredient> listIng4 = ip.readIngredientsBySousCategorie(803);
		
		
		System.out.println(listIng2.size()/5);
		System.out.println("\n");
		System.out.println(listIng3.size()/5);
		System.out.println("\n");
		System.out.println(listIng4.size()/5);
		System.out.println("\n");*/
		
		/*
		PerceptronUtility puti = new PerceptronUtility();
		System.out.println(listIng.size());
		System.out.println(puti.HeavySidePerceptron(5, 602));
		*/
		
		
		
		
		
		/*
		PerceptronUtility pu = new PerceptronUtility();
		HashMap<Ingredient, Double> k = pu.initiWeightEntry();
		FirstPerceptronEntry fpe = new FirstPerceptronEntry();
		
		ArrayList<Ingredient> a = ip.readAllIngredient();
		for (int i = 0; i < 2499; i++) {
			fpe.getIngredientEntry().put(a.get(i), 0);
			
		}
		System.out.println(k);
		System.out.println(k.size());
		System.out.println(fpe.getIngredientEntry().size());
		
		for(Ingredient i : k.keySet()) {
			System.out.println(fpe.getIngredientEntry().get(i));
			System.out.println(k.get(i));
			double sortie = fpe.getIngredientEntry().get(i)*k.get(i);
			System.out.println(sortie);
		}
		
		
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		FirstPerceptronEntry fpe = new FirstPerceptronEntry();
		PerceptronUtility pu = new PerceptronUtility();
		//System.out.println(pu.initiWeightEntry());
		ArrayList<Ingredient> a = ip.readAllIngredient();
		//System.out.println(a.size());
		for (Ingredient ing : a) {
			if(ing.getAlim_ssgrp_code() == 401) {
			fpe.getIngredientEntry().put(ing, 1);
			}
			else {
				fpe.getIngredientEntry().put(ing, 0);
			}
			//System.out.println(ing);
			//System.out.println(fpe.getIngredientEntry().get(ing));
			
		}
		//System.out.println(fpe.getIngredientEntry());
		
		int test = 0;
		for (Ingredient ing : fpe.getIngredientEntry().keySet()) {
			if(fpe.getIngredientEntry().get(ing)==1 && ing.getAlim_ssgrp_code()!= 401) {
			test ++;
			}
			//System.out.println(ing);
			//System.out.println(fpe.getIngredientEntry().get(ing));
			
		}
		
		HashMap<Ingredient, Integer> vectorResultByGroupCode = pu.creatVectorResultByGroupCode(fpe.getIngredientEntry(),401);
		
		int test10 = 0;
		for (Ingredient ing : vectorResultByGroupCode.keySet()) {
			if(vectorResultByGroupCode.get(ing)==1 && ing.getAlim_ssgrp_code()== 401) {
			test10 ++;
			}
			//System.out.println(ing);
			//System.out.println(fpe.getIngredientEntry().get(ing));
			
		}
		System.out.println(test10);
		System.out.println(test);
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		
		FirstPerceptron fp = new FirstPerceptron(fpe, pu) ;

		
		
		System.out.println(fp.resultAllPerceptron());
		/*System.out.println(fp.resultPerceptron(905));
		System.out.println(fp.resultPerceptron(401));
		System.out.println(fp.resultPerceptron(603));
		System.out.println(fp.resultPerceptron(0));
		System.out.println(fp.resultPerceptron(40));
		System.out.println(fp.resultPerceptron(1104));
		System.out.println(fp.resultPerceptron(702));*/
		
		/*
		
		System.out.println("\n");
		System.out.println("\n");
		IngredientPersistance ip3 = new IngredientPersistance();
		ArrayList<Ingredient> listIng = ip3.readIngredientsBySousCategorie(905);
		System.out.println("taille de 905 :" +listIng.size());
		ArrayList<Ingredient> listIng2 = ip3.readIngredientsBySousCategorie(401);
		System.out.println("taille de 401 :" + listIng2.size());
		ArrayList<Ingredient> listIng3 = ip3.readIngredientsBySousCategorie(603);
		System.out.println("taille de 603 :" +listIng3.size());
		
		ArrayList<Ingredient> listIng4 = ip3.readIngredientsBySousCategorie(0);
		System.out.println("taille de 0 :" +listIng4.size());
		ArrayList<Ingredient> listIng5 = ip3.readIngredientsBySousCategorie(40);
		System.out.println("taille de 40 :" +listIng5.size());
		ArrayList<Ingredient> listIng6 = ip3.readIngredientsBySousCategorie(1104);
		System.out.println("taille de 1104 :" +listIng6.size());
		ArrayList<Ingredient> listIng7 = ip3.readIngredientsBySousCategorie(702);
		System.out.println("taille de 702 :" +listIng7.size());
		
		
		
		/*IngredientPersistance ip1 = new IngredientPersistance();
		System.out.println(ip1.readIngredientsBySousCategorie(905).size());
		System.out.println(ip1.readIngredientsBySousCategorie(802).size());
		System.out.println(ip1.readIngredientsBySousCategorie(600).size());
		System.out.println(ip1.readIngredientsBySousCategorie(904).size());
*/
		/*
		for(Integer i : fp.resultAllPerceptron().keySet()) {
			if(fp.resultAllPerceptron().get(i)) {
				System.out.println(fp.resultAllPerceptron().get(i));
			}
		}*/
		
		
		
		
		
		
		/*
		
		
		IngredientPersistance ip = new IngredientPersistance();
		FirstPerceptronEntry fpe = new FirstPerceptronEntry();
		PerceptronUtility pu = new PerceptronUtility();
		
		ArrayList<Ingredient> a = ip.readAllIngredient();
		for (Ingredient ing : a) {
			if(ing.getAlim_ssgrp_code() == 401) {
			fpe.getIngredientEntry().put(ing, 1);
			}
			else {
				fpe.getIngredientEntry().put(ing, 0);
			}
			
		}	
		FirstPerceptron fp = new FirstPerceptron(fpe, pu);	
		
		//System.out.println(fp.resultAllPerceptron());
		SecondPerceptronEntry spe = new SecondPerceptronEntry(fpe, pu, fp);
		
		SecondPerceptron sp = new SecondPerceptron(spe);
		
		System.out.println(sp.resultPercep());
	
	*/
		
		/*
		
		
		RecipePersistance rp = new RecipePersistance();
		
		System.out.println(rp.readEtapeById(34009));
		
		Cleaner clean = new Cleaner();
		System.out.println(clean.cleanSteps(34009));
		
		*//*
		double start = 0;
		double end = 10;
		for(int i=0; i<10; i++  ) {
		double random = new Random().nextDouble();
		double result = start + (random * (end - start));


		}*/
		
		//IngredientRecipePersistance irp = new IngredientRecipePersistance();
		//System.out.println(irp.readIngredientByIdRecipe(11444)); 
		
		
	}
}
