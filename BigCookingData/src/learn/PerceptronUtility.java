package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import business.Ingredient;
import persistance.IngredientPersistance;

public class PerceptronUtility {

	public PerceptronUtility() {
		
	}
	
	
	public void initiWeightEntry (FirstPerceptronEntry perceptronEntry) {
		
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> a = ip.readAllIngredient();
	
		for(int i= 0; i<2499;i++) {
			perceptronEntry.getWeightEntry().put(a.get(i), Math.random());
		}
		
		/*for(Map.Entry<Ingredient,Double> mapEntry : perceptronEntry.getWeightEntry().entrySet()) {
			System.out.println(mapEntry.getValue());
			System.out.println(mapEntry.getKey().getId_ingredient());
			System.out.println("\n");	
		}
		System.out.println(perceptronEntry.getWeightEntry().size());*/
}
	public void initiIngredienttEntry (FirstPerceptronEntry perceptronEntry) {
		
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> a = ip.readAllIngredient();
	
		for(int i= 0; i<2499;i++) {
			perceptronEntry.getWeightEntry().put(a.get(i), 0.0);
		}
		/*
		for(Map.Entry<Ingredient,Double> mapEntry : perceptronEntry.getWeightEntry().entrySet()) {
			System.out.println(mapEntry.getValue());
			System.out.println(mapEntry.getKey().getId_ingredient());
			System.out.println("\n");	
		}
		System.out.println(perceptronEntry.getWeightEntry().size());*/
}
}