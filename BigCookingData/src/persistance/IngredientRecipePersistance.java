package persistance;

	import java.util.ArrayList;
import java.util.HashMap;

import business.Ingredient;
import business.SystemUtility;
import business.Ingredient;

import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;

public class IngredientRecipePersistance {

		public static HashMap<Ingredient,Integer> readIngredientByIdRecipe(int id) {
			HashMap<Ingredient,Integer> readIngredientMap = new HashMap<Ingredient,Integer>();
			try {
				String selectIngredientQuery = "SELECT * FROM ingredient_recipe WHERE id_recipe = ? ";
				Connection dbConnection = ConnectionDB.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
				preparedStatement.setInt(1, id);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
				
					int id_ingredient  = result.getInt("id_ingredient");
					Ingredient readIngredient = IngredientPersistance.readIngredientById(id_ingredient);
					int quantity = result.getInt("quantity");
					
					readIngredientMap.put(readIngredient,quantity);
				}
				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readIngredientMap;
		}

}
