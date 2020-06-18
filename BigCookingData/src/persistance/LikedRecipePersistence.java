package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LikedRecipePersistence {

	private Connection dbConnection;

	public LikedRecipePersistence() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public void addRecipe(int id_user, int id_recipe) {
		try {

			String selectUserQuery = "SELECT * FROM liked_recipes WHERE id_user = ? and id_recipe = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, id_recipe);
			ResultSet result = preparedStatement.executeQuery();
			

			if (!result.last()) {

				String insertVisitQuery = "INSERT INTO `liked_recipes`(`id_user`,`id_recipe`) VALUES (?,?)";
				java.sql.PreparedStatement preparedStatement1 = dbConnection.prepareStatement(insertVisitQuery);
				preparedStatement1.setInt(1, id_user);
				preparedStatement1.setInt(2, id_recipe);
				preparedStatement1.executeUpdate();
				preparedStatement1.close();
	
			}
			
			String removeLikeQuery = "DELETE FROM `disliked_recipes` WHERE `id_user`=? AND `id_recipe`=?";
			java.sql.PreparedStatement preparedStatement2 = dbConnection.prepareStatement(removeLikeQuery);
			preparedStatement2.setInt(1, id_user);
			preparedStatement2.setInt(2, id_recipe);
			preparedStatement2.executeUpdate();
			preparedStatement2.close();

			
			preparedStatement.close();
			
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}

	
	
	public ArrayList<Integer> readRecipesByIdUser(int id_user) {
		ArrayList<Integer> readRecipesList = new ArrayList<Integer>();
		try {
			String selectIngredientQuery = "SELECT * FROM liked_recipes WHERE id_user = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				readRecipesList.add(result.getInt("id_recipe"));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readRecipesList;
	}
	
	public boolean isLikedRecipeByUser(int id_user, int id_recipe) {
		
		
		try {
			String selectUserQuery = "SELECT * FROM liked_recipes WHERE id_user = ? AND id_recipe = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, id_recipe);
			ResultSet result = preparedStatement.executeQuery();

			if (!result.next()) {
				return false;
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return true;
	}
	
	
	
	
	
	
}
