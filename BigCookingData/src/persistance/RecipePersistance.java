package persistance;

import java.util.ArrayList;
import business.Recipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipePersistance {

	private Connection dbConnection;
	
	public RecipePersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public Recipe readRecipeById(int id) {
		Recipe readRecipe = new Recipe();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE id_recipe = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();
			
			while (result.next()) {
				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setIdIngredients(result.getInt("id_ingredient_recipe"));
				readRecipe.setName(result.getString("name"));
				readRecipe.setPrice(result.getInt("price"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setDifficutly(result.getInt("difficulty"));
				readRecipe.setTime(result.getString("time"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(id));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(" hoy "+se.getMessage());
		}

		return readRecipe;
	}

	public ArrayList<Recipe> readAllRecipe() {
		ArrayList<Recipe> readRecipeList = new ArrayList<Recipe>();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();			

			while (result.next()) {
				Recipe readRecipe = new Recipe();

				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setIdIngredients(result.getInt("id_ingredient_recipe"));
				readRecipe.setName(result.getString("name"));
				readRecipe.setPrice(result.getInt("price"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setDifficutly(result.getInt("difficulty"));
				readRecipe.setTime(result.getString("time"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(readRecipe.getId()));

				readRecipeList.add(readRecipe);
				System.out.println(readRecipe.getName());
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println("hey"+se.getMessage());
		}
		return readRecipeList;
	}

	public Recipe readRandRecipe() {
		Recipe readRecipe = new Recipe();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE RAND() > 0.9 ORDER BY RAND( ) LIMIT 1 ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();

			while (result.next()) {
				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setIdIngredients(result.getInt("id_ingredient_recipe"));
				readRecipe.setName(result.getString("name"));
				readRecipe.setPrice(result.getInt("price"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setDifficutly(result.getInt("difficulty"));
				readRecipe.setTime(result.getString("time"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(readRecipe.getId()));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return readRecipe;
	}
}