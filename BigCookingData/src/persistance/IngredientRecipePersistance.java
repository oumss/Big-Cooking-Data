package persistance;

import java.util.ArrayList;
import java.util.HashMap;
import business.Ingredient;
import business.Recipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRecipePersistance {

	private Connection dbConnection;

	public IngredientRecipePersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public HashMap<Ingredient, Integer> readIngredientByIdRecipe(int id) {
		HashMap<Ingredient, Integer> readIngredientMap = new HashMap<Ingredient, Integer>();
		try {
			String selectIngredientQuery = "SELECT * FROM ingredient_recipe WHERE id_recipe = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			IngredientPersistance ingredientPersist = new IngredientPersistance();

			while (result.next()) {
				int id_ingredient = result.getInt("id_ingredient");
				int quantity = 1;
				Ingredient readIngredient = ingredientPersist.readIngredientById(id_ingredient);
				
				try {
					quantity = result.getInt("quantity");
					
				} catch (Exception e) {
					quantity = 1;
				}
				
				readIngredientMap.put(readIngredient, quantity);
				
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return readIngredientMap;
	}


	public ArrayList<Recipe> readRecipesByIdIngredient(int id) {

		ArrayList<Recipe> readRecipes = new ArrayList<Recipe>();
		try {
			String selectIngredientQuery = "SELECT * FROM ingredient_recipe WHERE id_ingredient = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			RecipePersistance recipePersistance = new RecipePersistance();

			while (result.next()) {
				int id_recipe = result.getInt("id_recipe");
				Recipe readRecipe = recipePersistance.readRecipeById(id_recipe);
				readRecipes.add(readRecipe);
			}
			preparedStatement.close();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return readRecipes;
	}	
	
	
	public void addIngredientsRecipe(Recipe recipe, HashMap<String, String> nameMap, ArrayList<Ingredient> ingredientsAssociated, 
			ArrayList<String> ingredientsList, HashMap<String, String> quantityMap) {

		try { 
			int id_recipe = recipe.getId();
			for (int index = 0; index < ingredientsAssociated.size(); index++) {
				int id_ingredient = ingredientsAssociated.get(index).getId_ingredient();
				String quantity = quantityMap.get(ingredientsList.get(index));
				String ingredientList = nameMap.get(ingredientsList.get(index));

				String insertVisitQuery = "INSERT INTO `ingredient_recipe`(`id_recipe`,`id_ingredient`,`quantity`,`ingredientList`) VALUES (?,?,?,?)";
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(insertVisitQuery);
				preparedStatement.setInt(1, id_recipe);
				preparedStatement.setInt(2, id_ingredient);
				preparedStatement.setString(3, quantity);
				preparedStatement.setString(4, ingredientList);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				if (index == ingredientsAssociated.size() -1) 
					System.out.println("VALUES (?,?,?,?)"+" "+id_recipe +" "+id_ingredient+" "+quantity+" "+ingredientList);
			}
			//System.out.println(recipe.getTitle()+" insered");
			
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			System.out.println(recipe.getTitle());
			System.out.println(recipe.getIngredientsList());
			System.out.println("\n");
		}
	}
	
	
	
	public String readIngredientList(int id_recipe, int id_ingredient) {
		String resultat = "";
		try {
			String selectIngredientQuery = "SELECT * FROM ingredient_recipe WHERE id_ingredient = ? AND id_recipe = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, id_ingredient);
			preparedStatement.setInt(2, id_recipe);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				resultat = result.getString("ingredientList");
			}
			preparedStatement.close();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return resultat;
	}	

}
