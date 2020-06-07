package learnByPerceptron;

import java.util.HashMap;
import java.util.Random;

import persistance.WeightPerceptronPersistence;


public class PerceptronUtility {

	
	
	
	
	
	
	
	
	public double newWeight(int entry, float weight, float pasApp, float sortie, float sortieD) {
		return weight + pasApp * (sortieD - sortie) * entry;
	}
	
	
	public double calculSortiePerceptron(HashMap<String, Float> parameterEntry, HashMap<String, Float> weight) {
		float result = 0;
		for (String mapPerEntry : parameterEntry.keySet()) {
			result = result + (parameterEntry.get(mapPerEntry)* weight.get(mapPerEntry));
		}
		return result;
	}
	
	public boolean acceptSortie(HashMap<String, Float> parameterEntry, HashMap<String, Float> weight, int sortieD) {
		if (calculSortiePerceptron(parameterEntry, weight) >= 0 && sortieD ==1) {
			return true;
		}
		else if(calculSortiePerceptron(parameterEntry, weight) < 0 && sortieD == -1){
			return true;
		}
		else if(calculSortiePerceptron(parameterEntry, weight) >= 0 && sortieD == -1){
			return false;
		}
		else if (calculSortiePerceptron(parameterEntry, weight) < 0 && sortieD == 1){
			return false;
		}
		
		return false;
	}
	
	public void initiWeightEntry(HashMap<String, Float> parameterEntry, int id_user) {


		HashMap<String, Float> weightEntry = new HashMap<String, Float>();
		for (String parameter : parameterEntry.keySet()) {
			
			float start = 0;
			float end = 10;
			double random = new Random().nextDouble();
			float result = (float)(start + (random * (end - start)));
			
			weightEntry.put(parameter, result);

		
		}
		
		WeightPerceptronPersistence wpp = new WeightPerceptronPersistence();
		wpp.insertWeight(id_user, weightEntry);
	}
}