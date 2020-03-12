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
	
	
	public Ingredient associateIngredient(Ingredient ingredient) {
		IngredientPersistance ip = new IngredientPersistance();
		ArrayList<Ingredient> ingChoice = ip.readIngredientWithLike(ingredient);
		int current = 0;
		int near = 100; 
		for(Ingredient i: ingChoice) {
			int a = ingredient.getAlim_nom_fr().compareToIgnoreCase(i.getAlim_nom_fr());
			System.out.println(a);
			current = a*a;
			if ( current <= (near * near) )  {     
				near = a;
			}
		}
		System.out.println("\n\n\n" + near);
			
	
		
		return null;
	}
}
