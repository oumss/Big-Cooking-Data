package business;

import java.util.ArrayList;

import persistance.IngredientPersistance;
 
public class SystemUtility {

	private int id; 
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public SystemUtility() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	public String createQuery(String ingredient){
		String[] query = ingredient.split(" ");
		String result = "SELECT * FROM ingredient where alim_nom_fr like ";
		for (int i=0; i< query.length ; i++) {
			if (i == 0) {
				result = result +"'%"+ query[i] +"%'";
			}
			else if (i>0 && i<=query.length) {
				result = result + "and alim_nom_fr like '%"+ query[i] +"%'";
			}
			else{
				result = result + "and alim_nom_fr like '%"+ query[i] +"%'";
			}
			
		}
		return result;
	}
	public String createQueryWithOr(String ingredient){
		String[] query = ingredient.split(" ");
		String result = "SELECT * FROM ingredient where alim_nom_fr like ";
		for (int i=0; i< query.length ; i++) {
			if (i == 0) {
				result = result +"'%"+ query[i] +"%'";
			}
			else if (i>0 && i<=query.length) {
				result = result + "or alim_nom_fr like '%"+ query[i] +"%'";
			}
			else{
				result = result + "or alim_nom_fr like '%"+ query[i] +"%'";
			}
			
		}
		return result;
	}
	
	
}
