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
					readRecipe.setId_ingredient(result.getInt("id_ingredient"));
					readRecipe.setId_recipe(result.getInt("id_recipe"));
					readRecipe.setName(result.getString("name"));
					readRecipe.setPrice(result.getFloat("price"));
					readRecipe.setWeight(result.getInt("weight"));
					readRecipe.setTime(result.getInt("time"));

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
				String selectRecipeQuery = "SELECT * FROM user ";
				Connection dbConnection = ConnectionDB.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Recipe readRecipe = new Recipe();
					readRecipe.setId_ingredient(result.getInt("id_ingredient"));
					readRecipe.setId_recipe(result.getInt("id_recipe"));
					readRecipe.setName(result.getString("name"));
					readRecipe.setPrice(result.getFloat("price"));
					readRecipe.setWeight(result.getInt("weight"));
					readRecipe.setTime(result.getInt("time"));

					readRecipeList.add(readRecipe);
				}
				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readRecipeList;
		}
	}