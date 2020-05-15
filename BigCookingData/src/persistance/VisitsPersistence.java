package persistance;

import java.util.ArrayList;
import java.util.HashMap;

import business.Recipe;
import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitsPersistence {

	private Connection dbConnection;

	public VisitsPersistence() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public ArrayList<User>  readVisitsByIdRecipe(int id_recipe) {
		ArrayList<User> usersVisits = new ArrayList<User>();
		try {
			String selectUserQuery = "SELECT * FROM visits WHERE id_recipe = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_recipe);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				UserPersistance up = new UserPersistance();
				User user = up.readUserById(result.getInt("id_user"));
				usersVisits.add(user);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return usersVisits;
	}

	public ArrayList<Recipe> readVisitsByIdUser(User user) {
		int id_user = user.getId();
		ArrayList<Recipe> visitedRecipes = new ArrayList<Recipe>();
		try {
			String selectUserQuery = "SELECT * FROM visits WHERE id_user = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				RecipePersistance rp = new RecipePersistance();
				Recipe recipe = rp.readRecipeById(result.getInt("id_recipe"));
				visitedRecipes.add(recipe);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return visitedRecipes;
	}
	
	public ArrayList<Recipe> readLikedByIdUser(User user) {
		int id_user = user.getId();
		ArrayList<Recipe> likedRecipes = new ArrayList<Recipe>();
		try {
			String selectUserQuery = "SELECT * FROM visits WHERE id_user = ? WHERE liked = TRUE";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				RecipePersistance rp = new RecipePersistance();
				Recipe recipe = rp.readRecipeById(result.getInt("id_recipe"));
				likedRecipes.add(recipe);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return likedRecipes;
	}
}