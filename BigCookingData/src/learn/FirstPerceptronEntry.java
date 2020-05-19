package learn;


import java.util.HashMap;

import business.Ingredient;

public class FirstPerceptronEntry {

		private HashMap<Ingredient, Integer> ingredientEntry = new HashMap<Ingredient, Integer>();
		private double pasApp = 0.1;
		
		
		
		public HashMap<Ingredient, Integer> getIngredientEntry() {
			return ingredientEntry;
		}
		public void setIngredientEntry(HashMap<Ingredient, Integer> ingredientEntry) {
			this.ingredientEntry = ingredientEntry;
		}
		public double getPasApp() {
			return pasApp;
		}
		public void setPasApp(double pasApp) {
			this.pasApp = pasApp;
		}
	
}
