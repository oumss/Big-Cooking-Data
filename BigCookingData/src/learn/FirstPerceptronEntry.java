package learn;


import java.util.HashMap;

import business.Ingredient;

public class FirstPerceptronEntry {

		private HashMap<Ingredient, Integer> ingredientEntry = new HashMap<Ingredient, Integer>();
		private HashMap<Ingredient, Double> WeightEntry = new HashMap<Ingredient, Double>();
		private double pasApp = 0.1;
		
		
		
		public HashMap<Ingredient, Integer> getIngredientEntry() {
			return ingredientEntry;
		}
		public void setIngredientEntry(HashMap<Ingredient, Integer> ingredientEntry) {
			this.ingredientEntry = ingredientEntry;
		}
		public HashMap<Ingredient, Double> getWeightEntry() {
			return WeightEntry;
		}
		public void setWeightEntry(HashMap<Ingredient, Double> weightEntry) {
			WeightEntry = weightEntry;
		}
}
