package persistance;

import java.util.HashMap;

import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeightRecipePersistence {

			public int readWeightByIdRecipe(int id_recipe, User user) {
				int id_user = user.getId();
				int weight = 0;
				try {
					String selectUserQuery = "SELECT * FROM weight_recipe WHERE id_user = ? and id_recipe = ?";
					Connection dbConnection = ConnectionDB.getConnection();
					java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
					preparedStatement.setInt(1, id_user);
					preparedStatement.setInt(2, id_recipe);
					ResultSet result = preparedStatement.executeQuery();

					while (result.next()) {
						weight = result.getInt("weight_recipe");
					}
					preparedStatement.close();

				} catch (SQLException se) {
					System.err.println(se.getMessage());
				}
				return weight;
			}

			public static HashMap<Integer,Integer> readAllWeight(User user) {
				int id_user = user.getId();
				HashMap<Integer,Integer> weights = new HashMap<Integer,Integer>();
				try {
					String selectUserQuery = "SELECT * FROM weight_recipe WHERE id_user = ? ORDER BY weight_recipe";
					Connection dbConnection = ConnectionDB.getConnection();
					java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
					preparedStatement.setInt(1, id_user);
					ResultSet result = preparedStatement.executeQuery();

					while (result.next()) {
						weights.put(result.getInt("id_recipe"), result.getInt("weight_recipe"));

					}
					preparedStatement.close();

				} catch (SQLException se) {
					System.err.println(se.getMessage());
				}
				return weights;
			}
		}