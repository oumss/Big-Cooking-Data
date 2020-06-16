package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.User;

public class WeightPerceptronPersistence {
	

	private Connection dbConnection;

	public WeightPerceptronPersistence() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public void insertWeight(int id_user, HashMap<String, Float> weights) {
		try {

				String insertVisitQuery = "INSERT INTO `weight_perceptron`(`id_user`,`Eau (g/100g)`, `Sucres (g/100g)`, `Sel chlorure de sodium (g/100g)`, `Proteines (g/100g)`, `Glucides (g/100g)`,`Lipides (g/100g)`,`Energie, Reglement UE No 1169/2011 (kcal/100g)`, `W0`) VALUES (?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement preparedStatement1 = dbConnection.prepareStatement(insertVisitQuery);
				preparedStatement1.setInt(1, id_user);
				preparedStatement1.setFloat(2, weights.get("Eau (g/100g)"));
				preparedStatement1.setFloat(3, weights.get("Sucres (g/100g)"));
				preparedStatement1.setFloat(4, weights.get("Sel chlorure de sodium (g/100g)"));
				preparedStatement1.setFloat(5, weights.get("Proteines (g/100g)"));
				preparedStatement1.setFloat(6, weights.get("Glucides (g/100g)"));
				preparedStatement1.setFloat(7, weights.get("Lipides (g/100g)"));
				preparedStatement1.setFloat(8, weights.get("Energie, Reglement UE No 1169/2011 (kcal/100g)"));
				preparedStatement1.setFloat(9, weights.get("W0"));
				preparedStatement1.executeUpdate();
				preparedStatement1.close();

			}

			
		 catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}

	
	
	public HashMap<String, Float> getWeight(int id_user) {
		HashMap<String, Float> weights = new HashMap<String, Float>();
		try {
			String selectIngredientQuery = "SELECT * FROM weight_perceptron WHERE id_user = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				weights.put("Eau (g/100g)",result.getFloat("Eau (g/100g)"));
				weights.put("Sucres (g/100g)",result.getFloat("Sucres (g/100g)"));
				weights.put("Sel chlorure de sodium (g/100g)",result.getFloat("Sel chlorure de sodium (g/100g)"));
				weights.put("Proteines (g/100g)",result.getFloat("Proteines (g/100g)"));
				weights.put("Glucides (g/100g)",result.getFloat("Glucides (g/100g)"));
				weights.put("Lipides (g/100g)",result.getFloat("Lipides (g/100g)"));
				weights.put("Energie, Reglement UE No 1169/2011 (kcal/100g)",result.getFloat("Energie, Reglement UE No 1169/2011 (kcal/100g)"));
				weights.put("W0",result.getFloat("W0"));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return weights;
	}
	
	
	public boolean existWeight(int id_user) {
		
		
		try {
			String selectUserQuery = "SELECT * FROM weight_perceptron WHERE id_user = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
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
	
	
	
	
	public float getUniqueWeight(String colonne, int id_user) {
		
		float resultat = 0;
		try {
			String selectUserQuery = "SELECT * FROM weight_perceptron WHERE id_user = ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next()) {
				resultat = result.getFloat(colonne);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return resultat;
	}
	
	
	
	
	
	public void updateWeight(String colonne, float newWeight, int id_user) {
		
		try {
				String updateVisitQuery = "UPDATE `weight_perceptron` SET `"+colonne+"`=? WHERE id_user = ?";
				java.sql.PreparedStatement preparedStatement2 = dbConnection.prepareStatement(updateVisitQuery);
				preparedStatement2.setFloat(1, newWeight);
				preparedStatement2.setInt(2, id_user);
				preparedStatement2.executeUpdate();
				preparedStatement2.close();
			


		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}
	
	
	
	//Pour tester hein
	public HashMap<String, Float> getWeightbis(int id_user) {
		HashMap<String, Float> weights = new HashMap<String, Float>();
		try {
			String selectIngredientQuery = "SELECT * FROM weight_perceptron WHERE id_user = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				weights.put("Sucres (g/100g)",result.getFloat("Sucres (g/100g)"));
				weights.put("Sel chlorure de sodium (g/100g)",result.getFloat("Sel chlorure de sodium (g/100g)"));
				weights.put("Glucides (g/100g)",result.getFloat("Glucides (g/100g)"));
				weights.put("Lipides (g/100g)",result.getFloat("Lipides (g/100g)"));
				
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return weights;
	}
	

}
