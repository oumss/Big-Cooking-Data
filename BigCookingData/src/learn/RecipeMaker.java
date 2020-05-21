package learn;

import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.Recipe;

public class RecipeMaker {
	
	public ArrayList<Recipe> proposition(HashMap<Ingredient, Integer> entry){
		
		FirstPerceptronEntry fpe = new FirstPerceptronEntry(entry);
		PerceptronUtility pu = new PerceptronUtility();
		
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
