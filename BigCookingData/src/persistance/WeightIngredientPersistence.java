package persistance;

import java.util.HashMap;

import business.Ingredient;
import business.Recipe;
import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeightIngredientPersistence {

	private Connection dbConnection;

	public WeightIngredientPersistence() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	/**
	 * incrémente le poid d'un ingredient grace a la visite d'une recette, rajoute
	 * la ligne et initialise à 1 si l'ingredient n'est pas dans la table.
	 * 
	 * @param user
	 * @param ingredient
	 */
	public void addWeightVisit(User user, Ingredient ingredient) {
		try {
			int id_user = user.getId();

			String selectUserQuery = "SELECT * FROM weight_ingredient WHERE id_user = ? and id_ingredient = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, ingredient.getId_ingredient());
			ResultSet result = preparedStatement.executeQuery();
			preparedStatement.close();

			if (result.last()) {

				int weight = result.getInt("weight_ingredient");
				String updateVisitQuery = "UPDATE `weight_ingredient` SET `weight_ingredient`=? WHERE id_ingredient = ? and id_user = ?";
				java.sql.PreparedStatement preparedStatement2 = dbConnection.prepareStatement(updateVisitQuery);
				preparedStatement2.setInt(1, weight + 1);
				preparedStatement2.setInt(2, ingredient.getId_ingredient());
				preparedStatement2.setInt(3, id_user);
				preparedStatement2.executeQuery();
				preparedStatement2.close();
			}

			String insertVisitQuery = "INSERT INTO `weight_ingredient`(`id_user`,`id_ingredient`,`weight_ingredient` ) VALUES (?,?,?)";
			java.sql.PreparedStatement preparedStatement3 = dbConnection.prepareStatement(insertVisitQuery);
			preparedStatement3.setInt(1, id_user);
			preparedStatement3.setInt(2, ingredient.getId_ingredient());
			preparedStatement3.setInt(3, 1);
			preparedStatement3.executeQuery();
			preparedStatement3.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}

	/**
	 * incrémente le poid d'un ingredient grace au like d'une recette
	 * 
	 * @param user
	 * @param ingredient
	 */
	public void addWeightLike(User user, Ingredient ingredient) {
		int id_user = user.getId();
		int id_ingredient = ingredient.getId_ingredient();
		int weight = readWeightByIdIngredient(id_ingredient, user);
		try {
			String updateVisitQuery = "UPDATE `weight_ingredient` SET `weight_ingredien`=? WHERE id_ingredient = ? and id_user = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(updateVisitQuery);
			preparedStatement.setInt(1, weight + 2);
			preparedStatement.setInt(2, id_ingredient);
			preparedStatement.setInt(3, id_user);
			preparedStatement.executeQuery();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}

	public int readWeightByIdIngredient(int id_ingredient, User user) {
		int id_user = user.getId();
		int weight = 0;
		try {
			String selectUserQuery = "SELECT * FROM weight_ingredient WHERE id_user = ? and id_ingredient = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, id_ingredient);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				weight = result.getInt("weight_ingredient");
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return weight;
	}

	public void incrementWeight(Ingredient ingredient, User user) {
		ingredient.setPoids(ingredient.getPoids() + 1);
		try {

			java.sql.Statement addStatement = dbConnection.createStatement();
			addStatement.executeUpdate(
					"UPDATE weight_ingredient SET weight_ingredient ='" + ingredient.getPoids() + "' WHERE id_user ="
							+ user.getId() + " AND id_ingredient =" + ingredient.getId_ingredient() + ";");

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}

	public void decrementWeight(Ingredient ingredient, User user) {
		if (ingredient.getPoids() != 0) {
			ingredient.setPoids(ingredient.getPoids() - 1);
		}
		try {

			java.sql.Statement addStatement = dbConnection.createStatement();
			addStatement.executeUpdate(
					"UPDATE weight_ingredient SET weight_ingredient ='" + ingredient.getPoids() + "' WHERE id_user ="
							+ user.getId() + " AND id_ingredient =" + ingredient.getId_ingredient() + ";");

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}

	public HashMap<Integer, Integer> readAllWeight(User user) {
		int id_user = user.getId();
		HashMap<Integer, Integer> weights = new HashMap<Integer, Integer>();
		try {
			String selectUserQuery = "SELECT * FROM weight_ingredient WHERE id_user = ? ORDER BY weight_ingredient";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				weights.put(result.getInt("id_ingredient"), result.getInt("weight_ingredient"));

			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return weights;
	}
}