package learn;

import java.util.ArrayList;

import business.Recipe;

public class Cluster {
	
	private ArrayList<Recipe> listeRecipesCluster = new ArrayList<Recipe>();
	private Recipe centre;
	
	//A définir
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


	//A définir
	public boolean calculerCentre() {
		
		
		
		return false;
	}

}
