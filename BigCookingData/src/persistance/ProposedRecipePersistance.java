package persistance;

import java.util.ArrayList;
import business.Recipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProposedRecipePersistance {

	private Connection dbConnection;
	
	public ProposedRecipePersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public ArrayList<Recipe> readProposedRecipeByIdUser(int id) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try {
			String selectRecipeQuery = "SELECT * FROM proposed_recipe_user WHERE id_user = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			RecipePersistance rp = new RecipePersistance();
			
			while (result.next()) {
				int id_recipe = result.getInt("id_recipe");
				Recipe readRecipe = rp.readRecipeById(id_recipe);
				recipes.add(readRecipe);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return recipes;
	}
	
	public void addProposedRecipeByIdUser(int id_user, int id_recipe) {
		try {
			String selectRecipeQuery = "INSERT INTO `proposed_recipe_user`(`id_user`, `id_recipe`, `visited`) VALUES (?,?,?)";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, id_recipe);
			preparedStatement.setBoolean(3, true);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}

	public void removeProposedRecipeByIdUser(int id_user, int id_recipe) {
		try {
			String selectRecipeQuery = "DELETE FROM `proposed_recipe_user`WHERE `id_user`=?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	
}