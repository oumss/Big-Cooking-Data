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
	
	public double calculSortieNeurone (int entry, double weight) {
		return entry*weight;
	}
	
	
	public double newWeight (int entry, double weight, double pasApp, double sortie, double sortieD) {
		return weight+pasApp*(sortieD-sortie)*entry;
	}
	
	public boolean acceptSortie (int entry, double weight, int sortieD, double error ) {
		if (Math.abs(calculSortieNeurone(entry,weight)-sortieD)<0.1) {
			return true;
		}
		return false;
	}
	
	public double calculSortiePerceptron (HashMap<Ingredient, Integer> perEntry, HashMap<Ingredient, Double> weight ) {
		double result = 0.0;
		for(Map.Entry<Ingredient,Integer> mapPerEntry : perEntry.entrySet()) {
			for(Map.Entry<Ingredient,Double> mapWeight : weight.entrySet()) {
				if (mapPerEntry.getKey().equals(mapWeight.getKey())) {
					result = result + calculSortieNeurone(mapPerEntry.getValue(), mapWeight.getValue());
				}	
			}
		}
		return result;
	}
	
}