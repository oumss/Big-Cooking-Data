package test;
import testLearnPerceptron.Perceptron;
import testLearnPerceptron.PerceptronUtility;

import java.util.ArrayList;

import business.Ingredient;
import business.Recipe;
import clean.SystemUtility;
import ingredients.Cleaner;
import persistance.DislikedRecipePersistence;
import persistance.IngredientRecipePersistance;
import persistance.LikedRecipePersistence;
import persistance.RecipePersistance;


public class TestSamir {

	public static void main(String[] args) {
		
		/*Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();
		ingredient.setAlim_nom_fr("chou-fleur");
		//System.out.println(ingredient.toString()+"\n");
		//System.out.println("Ingr�dient � comparer : tomate");
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
		c.setAlim_nom_fr("Tomate concentr� appertis�");
		
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
		
		
		//IngredientPersistance ip = new IngredientPersistance();
		
		//System.out.println(ip.getTaux(13004));
		
		
		//IngredientRecipePersistance irp = new IngredientRecipePersistance();
		
		//System.out.println(irp.readIngredientList(1, 18163));
		
		
		LikedRecipePersistence lrp = new LikedRecipePersistence();
		DislikedRecipePersistence drp = new DislikedRecipePersistence();
		
		Perceptron p = new Perceptron();
		PerceptronUtility pu = new PerceptronUtility();
		
		RecipePersistance rp = new RecipePersistance();
		
		// 59 63 103 142 151 164 203 258
		
		Recipe r = rp.readRecipeById(59); //Sainte Aurore (g�teau chocolat- poire fourr� mousse chocolat-framboise gla�age fudge)
		Recipe r2= rp.readRecipeById(63); //quatre-quarts caramel ananas
		Recipe r4 = rp.readRecipeById(103); // g�teau au yaourt et nutella
		Recipe r5 = rp.readRecipeById(142); // G�teaux au miel et � la cannelle
		Recipe r6= rp.readRecipeById(151); // g�teau facile au chocolat fa�on Salete
		Recipe r7= rp.readRecipeById(164); // Gateau semoule coco raisins
		Recipe r8= rp.readRecipeById(203); // G�teau au Get 27
		Recipe r9= rp.readRecipeById(258); // gateau des grisons aux noix, par missc
		
		//24 50 365 367 377 468 538 596 672
		
		Recipe r11 = rp.readRecipeById(17); // Patina de concombre (cuisine romaine)
		Recipe r12 = rp.readRecipeById(37); // Fish Pie ( plat traditionnel anglais )
		Recipe r13 = rp.readRecipeById(69); // lasagnes de la mer parfum�es � la noix de coco et son coulis d'avocat
		Recipe r14 = rp.readRecipeById(83); // spaghetti aux fruits de mer express
		Recipe r15 = rp.readRecipeById(114); // poisson micro-ondes
		Recipe r16 = rp.readRecipeById(186); // La marmite du p�cheur
		Recipe r17 = rp.readRecipeById(209); // Ceviche p�ruvien de poisson
		Recipe r18 = rp.readRecipeById(270); // citrons farcis aux poissons
		Recipe r19 = rp.readRecipeById(284); // Salade de pommes de terre aux poissons fum�s (Lituanie)
		


 
	
		System.out.println("SUCREE");
		System.out.println("\n");
		System.out.println(r.getTitle()+" : "+pu.calculateTaux(r, 1));
		System.out.println(r2.getTitle()+" : "+pu.calculateTaux(r2, 1));
		System.out.println(r4.getTitle()+" : "+pu.calculateTaux(r4, 1));
		System.out.println(r5.getTitle()+" : "+pu.calculateTaux(r5, 1));
		System.out.println(r6.getTitle()+" : "+pu.calculateTaux(r6, 1));
		System.out.println(r7.getTitle()+" : "+pu.calculateTaux(r7, 1));
		System.out.println(r8.getTitle()+" : "+pu.calculateTaux(r8, 1));
		System.out.println(r9.getTitle()+" : "+pu.calculateTaux(r9, 1));
		System.out.println("\n");
		System.out.println("SALEE");
		System.out.println("\n");
		System.out.println(r11.getTitle()+" : "+pu.calculateTaux(r11, 1));
		System.out.println(r11.getTitle()+" : "+pu.calculateTaux(r12, 1));
		System.out.println(r12.getTitle()+" : "+pu.calculateTaux(r13, 1));
		System.out.println(r13.getTitle()+" : "+pu.calculateTaux(r14, 1));
		System.out.println(r14.getTitle()+" : "+pu.calculateTaux(r15, 1));
		System.out.println(r15.getTitle()+" : "+pu.calculateTaux(r16, 1));
		System.out.println(r16.getTitle()+" : "+pu.calculateTaux(r17, 1));
		System.out.println(r17.getTitle()+" : "+pu.calculateTaux(r18, 1));
		System.out.println(r18.getTitle()+" : "+pu.calculateTaux(r19, 1));
		
		
		
		
		System.out.println("\n");
		System.out.println("\n");
		/*
		System.out.println(rp.readAllFirstsRecipe().size());
		System.out.println(rp.readAllFirstsRecipe().get(288).getId());
		
		*/
		/*
		System.out.println("\n");
		
		lrp.addRecipe(5, 2);   
		lrp.addRecipe(5, 16);
		lrp.addRecipe(5, 1687);
		lrp.addRecipe(5, 2717);
		
		
		
		
		drp.addRecipe(5, 2720);
		drp.addRecipe(5, 13);
		drp.addRecipe(5, 22);
		drp.addRecipe(5, 23);
		drp.addRecipe(5, 17);
		*/
		
		/*
		PerceptronUtility pu = new PerceptronUtility();
		RecipePersistance rp = new RecipePersistance();
		ArrayList<Recipe> test = rp.readAllRecipe();
		ArrayList<Recipe> test2 = new ArrayList<Recipe>();
		for (int i = 0; i < 10000; i++) {
			test2.add(test.get(i));
		}
		System.out.println(test2.size());
		System.out.println(pu.filter(test2).size());
		*/
		
		
		
		
		/*
		IngredientRecipePersistance irp = new IngredientRecipePersistance();
		System.out.println(irp.existRecipe(1222));
		System.out.println(irp.existRecipe(7));
		*/
		/*learnByPerceptron.PerceptronUtility pu = new learnByPerceptron.PerceptronUtility();
		
		pu.initiWeightEntry(12);
		/*pu.initiWeightEntry(14);
		pu.initiWeightEntry(16);
		pu.initiWeightEntry(18);*/
		
		/*WeightPerceptronPersistence wpp = new WeightPerceptronPersistence();
		
		wpp.updateWeight("Sucres (g/100g)", (float)2.33333, 13);
		/*
		System.out.println(wpp.existWeight(12));
		System.out.println(wpp.existWeight(13));
		System.out.println(wpp.existWeight(14));
		System.out.println(wpp.existWeight(15));
		System.out.println(wpp.existWeight(16));
		System.out.println(wpp.existWeight(17));
		System.out.println(wpp.existWeight(18));
		System.out.println(wpp.existWeight(19));
		System.out.println(wpp.existWeight(20));
		System.out.println(wpp.existWeight(21));
		System.out.println(wpp.existWeight(22));
		*/
		
		//12 	0.0606461 	4.34992 	2.7124 	1.36039 	1.76787 	0.765809 	7.31846
		//pu.initiWeightEntry(2);
		//p.apprentissage(5);
		
		//p.proposition(5);
		
		//Cleaner c = new Cleaner();
		
		//System.out.println(c.cleanSteps(59));
		
		//System.out.println(p.proposition(12));
		
		
		
		/*
		
		Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();
		ingredient.setAlim_nom_fr("carottes");
		//System.out.println(ingredient.toString()+"\n");
		//System.out.println("Ingr�dient � comparer : tomate");
		System.out.println(ingredient);
		//u.transformIngredientName(ingredient);
		//System.out.println(ingredient.toString()+"\n");
		/*
		ingredient = u.associateIngredient(ingredient);
		
		System.out.println("\n");
		System.out.println(ingredient);*/
		//System.out.println(ingredient.toString());
		
	}
}
