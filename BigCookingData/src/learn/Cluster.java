package learn;

import java.util.ArrayList;

import business.Recipe;

public class Cluster {
	
	private ArrayList<Recipe> listeRecipesCluster = new ArrayList<Recipe>();
	private Recipe centre;
	
	//A d�finir
	public Cluster(Recipe recipe) {
			
	}

	
	
	public Recipe getCentre() {
		return centre;
	}

	public void setCentre(Recipe centre) {
		this.centre = centre;
	}

	public ArrayList<Recipe> getListeRecipesCluster() {
		return listeRecipesCluster;
	}

	public void setListeRecipesCluster(ArrayList<Recipe> listeRecipesCluster) {
		this.listeRecipesCluster = listeRecipesCluster;
	}


	//A d�finir
	public boolean calculerCentre() {
		
		
		
		return false;
	}

}
