package ingredients;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import business.Ingredient;
import business.Recipe;
import clean.SystemUtility;
import persistance.IngredientPersistance;
import persistance.IngredientRecipePersistance;
import persistance.RecipePersistance;

public class IngredientsToBase {

	private RecipePersistance rp = new RecipePersistance();
	private IngredientRecipePersistance irp = new IngredientRecipePersistance();
	private SystemUtility su = new SystemUtility();

	/**
	 * Fonction principal pour la mise en base des ingredients d'une recette
	 * @throws IOException 
	 */
	public IngredientsToBase() throws IOException {
		init();
		System.out.println("FIN GENERATION REQUETES ######");
	}

	public void init() throws IOException {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		recipes.addAll(rp.readAllRecipe());

		for (Recipe recipe : recipes) {
			HashMap<String, String> quantityMap = new HashMap<String, String>();
			ArrayList<Ingredient> ingredientsAssociated = new ArrayList<Ingredient>();
			ArrayList<String> ingredientsList = new ArrayList<String>();
			String ingredientString ="";
			ingredientString = recipe.getIngredientsList();
			HashMap<String, String> nameMap = new HashMap<String, String>();
			nameMap = readIngredientsList(ingredientString);
			
			if (!(nameMap.equals(null))) {
				for (String key : nameMap.keySet()) {
					String value = nameMap.get(key);
					String[] partValue = value.split(" ");
					String quantity;
					if (partValue.length != 0) {
						quantity = partValue[0];
					} else {
						quantity = "";
					}
					quantityMap.put(key, quantity);
				}
				for (String key : nameMap.keySet()) {
					Ingredient ingredientKey = new Ingredient();
					ingredientKey.setAlim_nom_fr(key);
					ingredientsList.add(key);
					Ingredient ingredient = su.associateIngredient(ingredientKey);
					ingredientsAssociated.add(ingredient);
				}
			}
			for (int index = 0; index < ingredientsAssociated.size(); index++) {
				int id_ingredient = ingredientsAssociated.get(index).getId_ingredient();
				String quantity = quantityMap.get(ingredientsList.get(index));
				String ingredientList = nameMap.get(ingredientsList.get(index));
				queryMaker(recipe,id_ingredient, quantity,ingredientList);
			}
			//irp.addIngredientsRecipe(recipe, nameMap, ingredientsAssociated, ingredientsList, quantityMap);
		}
	}
	
	public void queryMaker(Recipe recipe,int id_ingredient, String quantity, String ingredientList) throws IOException {
		FileWriter insertFile = new FileWriter(new File("src//ingredients//insert_ingredientsRecipe.txt").getAbsolutePath(),true);
		BufferedWriter bw = new BufferedWriter(insertFile);
		String insert = "";
		if (quantity.equals("")) quantity = " ";
		int id_recipe = recipe.getId();
		insert = "INSERT INTO ingredient_recipe ( id_recipe, id_ingredient, quantity, ingredientList)"
				+ "VALUES (" + id_recipe + "," + id_ingredient + ",'" + quantity + "',\"" + ingredientList +"\");\n";
		System.out.println(insert);
		bw.write(insert);
		bw.close();
	}
	
	public HashMap<String, String> readIngredientsList(String ingredientsList) {
		
		HashMap<String, String> ingredientMap = new HashMap<String, String>();
		if (ingredientsList==null) {
			return ingredientMap;
		}
		String[] line = ingredientsList.split("},");
		for (int index = 0; index < line.length; index++) {
			String[] partLine = line[index].split(",");
			String prefix = "";
			String name = "";
			String complement = "";
			String quantity = "";
			for (int index2 = 0; index2 < partLine.length; index2++) {
				String[] part = partLine[index2].split("\"");

				if (partLine[index2].contains("prefix")) {
					prefix = part[3];
				}
				if (partLine[index2].contains("complement")) {
					complement = part[3];
				}
				if (partLine[index2].contains("quantity")) {
					quantity = part[3];
				}
				if (partLine[index2].contains("name")) {
					name = part[3];
				} else {
					continue;
				}

			}
			String res = quantity + " " + prefix + " " + name + " " + complement;
			ingredientMap.put(name, res);
		}
		return ingredientMap;
		
	}

	public RecipePersistance getRp() {
		return rp;
	}

	public void setRp(RecipePersistance rp) {
		this.rp = rp;
	}

	public IngredientRecipePersistance getIrp() {
		return irp;
	}

	public void setIrp(IngredientRecipePersistance irp) {
		this.irp = irp;
	}

	public SystemUtility getSu() {
		return su;
	}

	public void setSu(SystemUtility su) {
		this.su = su;
	}

}
