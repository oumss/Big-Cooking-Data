package learn;


import java.util.HashMap;

import business.Ingredient;

public class FirstPerceptronEntry {

		private HashMap<Ingredient, Integer> ingredientEntry = new HashMap<Ingredient, Integer>();
		private HashMap<Ingredient, Double> weightEntry = new HashMap<Ingredient, Double>();
		private double pasApp = 0.1;
		
		
		
		public HashMap<Ingredient, Integer> getIngredientEntry() {
			return ingredientEntry;
		}
		public void setIngredientEntry(HashMap<Ingredient, Integer> ingredientEntry) {
			this.ingredientEntry = ingredientEntry;
		}
		public HashMap<Ingredient, Double> getWeightEntry() {
			return weightEntry;
		}
		public void setWeightEntry(HashMap<Ingredient, Double> weightEntry) {
			this.weightEntry = weightEntry;
		}
		public double getPasApp() {
			return pasApp;
		}
		public void setPasApp(double pasApp) {
			this.pasApp = pasApp;
		}
		
		
		
	
}
