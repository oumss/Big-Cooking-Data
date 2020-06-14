package test;
import testLearnPerceptron.Perceptron;
import testLearnPerceptron.PerceptronUtility;
import business.Recipe;
import persistance.DislikedRecipePersistence;
import persistance.LikedRecipePersistence;
import persistance.RecipePersistance;


public class TestSamir {

	public static void main(String[] args) {
		
		/*Ingredient ingredient = new Ingredient();
		SystemUtility u = new SystemUtility();
		ingredient.setAlim_nom_fr("chou-fleur");
		//System.out.println(ingredient.toString()+"\n");
		//System.out.println("Ingrï¿½dient ï¿½ comparer : tomate");
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
		c.setAlim_nom_fr("Tomate concentrï¿½ appertisï¿½");
		
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
		Perceptron p = new Perceptron();/**/
		PerceptronUtility pu = new PerceptronUtility();/*
		RecipePersistance rp = new RecipePersistance();
		
		Recipe r = rp.readRecipeById(2);
		Recipe r1 = rp.readRecipeById(16);
		Recipe r2= rp.readRecipeById(1687);
		Recipe r4 = rp.readRecipeById(2717);
		Recipe r5 = rp.readRecipeById(2720);
		Recipe r6= rp.readRecipeById(13);
		Recipe r7= rp.readRecipeById(22);
		Recipe r8= rp.readRecipeById(23);
		Recipe r9= rp.readRecipeById(17);
		
		System.out.println("recette sucrée:");
		System.out.println("\n");
		System.out.println(pu.calculateTaux(r, 1));
		System.out.println(pu.calculateTaux(r1, 1));
		System.out.println(pu.calculateTaux(r2, 1));
		System.out.println(pu.calculateTaux(r4, 1));
		System.out.println("\n");
		System.out.println("recette salée:");
		System.out.println("\n");
		System.out.println(pu.calculateTaux(r5, 1));
		System.out.println(pu.calculateTaux(r6, 1));
		System.out.println(pu.calculateTaux(r7, 1));
		System.out.println(pu.calculateTaux(r8, 1));
		System.out.println(pu.calculateTaux(r9, 1));
		*/
		
		lrp.addRecipe(12, 2);   
		lrp.addRecipe(12, 16);
		lrp.addRecipe(12, 1687);
		lrp.addRecipe(12, 2717);
		
		
		
		
		drp.addRecipe(12, 2720);
		drp.addRecipe(12, 13);
		drp.addRecipe(12, 22);
		drp.addRecipe(12, 23);
		drp.addRecipe(12, 17);
		
		
		
		
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
		//pu.initiWeightEntry(12);
		p.apprentissage(12);
		
		//System.out.println(p.proposition(12));
		
		
		
	}
}
