package persistance;

import java.util.ArrayList;
import business.Recipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipePersistance {

	public Recipe readRecipeById(int id) {
		Recipe readRecipe = new Recipe();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE id_recipe = ? ";
			Connection dbConnection = ConnectionDB.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				readRecipe.setId_recipe(result.getInt("id_recipe"));
				readRecipe.setId_ingredient_recipe(result.getInt("id_ingredient_recipe"));
				readRecipe.setName(result.getString("name"));
				readRecipe.setPrice(result.getInt("price"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setDifficutly(result.getInt("difficulty"));
				readRecipe.setTime(result.getString("time"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(IngredientRecipePersistance.readIngredientByIdRecipe(id));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return readRecipe;
	}

	public static ArrayList<Recipe> readAllRecipe() {
		ArrayList<Recipe> readRecipeList = new ArrayList<Recipe>();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe ";
			Connection dbConnection = ConnectionDB.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Recipe readRecipe = new Recipe();

				readRecipe.setId_recipe(result.getInt("id_recipe"));
				readRecipe.setId_ingredient_recipe(result.getInt("id_ingredient_recipe"));
				readRecipe.setName(result.getString("name"));
				readRecipe.setPrice(result.getInt("price"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setDifficutly(result.getInt("difficulty"));
				readRecipe.setTime(result.getString("time"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(IngredientRecipePersistance.readIngredientByIdRecipe(readRecipe.getId_recipe()));

				readRecipeList.add(readRecipe);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readRecipeList;
	}

	public Recipe readRandRecipe() {
		Recipe readRecipe = new Recipe();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE RAND() > 0.9 ORDER BY RAND( ) LIMIT 1 ";
			Connection dbConnection = ConnectionDB.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				readRecipe.setId_recipe(result.getInt("id_recipe"));
				readRecipe.setId_ingredient_recipe(result.getInt("id_ingredient_recipe"));
				readRecipe.setName(result.getString("name"));
				readRecipe.setPrice(result.getInt("price"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setDifficutly(result.getInt("difficulty"));
				readRecipe.setTime(result.getString("time"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(IngredientRecipePersistance.readIngredientByIdRecipe(readRecipe.getId_recipe()));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return readRecipe;
	}
}