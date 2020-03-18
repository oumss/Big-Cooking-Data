package persistance;

import java.util.HashMap;

import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeightIngredientPersistence {

	private Connection dbConnection;

	public WeightIngredientPersistence() {
		this.dbConnection = ConnectionDB.getConnection();
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