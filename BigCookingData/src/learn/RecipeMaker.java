package learn;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import business.User;
import persistance.IngredientPersistance;
import persistance.WeightIngredientPersistence;

public class RecipeMaker {
	
	public ArrayList<Recipe> proposition(User user){
		PerceptronUtility pu = new PerceptronUtility();
		FirstPerceptronEntry fpe = new FirstPerceptronEntry(pu.vectorEntry(user));
	
		FirstPerceptron fp = new FirstPerceptron(fpe, pu);
		
		SecondPerceptronEntry spe = new SecondPerceptronEntry(fpe, pu, fp);
		SecondPerceptron sp = new SecondPerceptron(spe);
		
		
		return sp.resultPercep();
	}

	public ArrayList<Recipe> initialproposition(HashMap<Integer, Boolean> entry){
		
		FirstPerceptronEntry fpe = new FirstPerceptronEntry();
		PerceptronUtility pu = new PerceptronUtility();
		
		FirstPerceptron fp = new FirstPerceptron(fpe, pu);
		
		SecondPerceptronEntry spe = new SecondPerceptronEntry(fpe, pu, fp);
		SecondPerceptron sp = new SecondPerceptron(spe);
		
		
		return sp.resultPercepInit(entry);
		
	}
}
