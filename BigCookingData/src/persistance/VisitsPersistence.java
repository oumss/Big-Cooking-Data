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

	/**
	 * Fonction ajoute une visite d'une recette pour l'utilisateur dans la BD
	 * @param user Utilisateur qui a visité la recette
	 * @param recipe Recette visité par l'utilisateur
	 */
	public void  addVisitRecipe(User user, Recipe recipe) {
		try {
			int id_user = user.getId();
			int id_recipe = recipe.getId();
			String insertVisitQuery = "INSERT INTO `visits`(`id_user`,`id_recipe`,`liked`) VALUES (?,?,?)";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(insertVisitQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, id_recipe);
			preparedStatement.setBoolean(3, false);
			preparedStatement.executeQuery();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	/**
	 * Fonction qui met l'attribut liked a TRUE dans la BD pour la recette visitée par l'utilisateur.
	 * @param user Utilisateur qui a liké la recette
	 * @param recipe Recette liké par l'utilisateur
	 */
	public void  addLikeRecipe(User user, Recipe recipe) {
		int id_user = user.getId();
		int id_recipe = recipe.getId();
		try {
			String updateVisitQuery = "UPDATE `visits` SET `liked`=? WHERE id_recipe = ? and id_user = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(updateVisitQuery);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, id_recipe);
			preparedStatement.setInt(3, id_user);
			preparedStatement.executeQuery();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	
	/**
	 * Recupere la liste des utilisateurs qui ont visité la recette
	 * @param id_recipe ID de la recette
	 * @return liste d'utilisateurs
	 */
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

	/**
	 * Recupere toutes les recettes visités par l'utilisateur
	 * @param user Utilisateur
	 * @return liste de recettes
	 */
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
	
	/**
	 * Recupere toutes les recettes likées par l'utilisateur
	 * @param user
	 * @return liste de recettes
	 */
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