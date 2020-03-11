package persistance;

	import java.util.ArrayList;
	import business.Ingredient;
import business.SystemUtility;
import business.Ingredient;

import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;

public class IngredientPersistance {

		public static Ingredient readIngredientById(int id) {
			Ingredient readIngredient = new Ingredient();
			try {
				String selectIngredientQuery = "SELECT * FROM user WHERE id_ingredient = ? ";
				Connection dbConnection = ConnectionDB.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
				preparedStatement.setInt(1, id);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					readIngredient.setId_ingredient(result.getInt("id_ingredient"));
					readIngredient.setAlim_nom_fr(result.getString("alim_nom_fr"));
					readIngredient.setAlim_grp_code(result.getInt("alim_grp_code"));
					readIngredient.setAlim_ssgrp_code(result.getInt("alim_ssgrp_code"));
					readIngredient.setAlim_ssssgrp_code(result.getInt("alim_ssssgrp_code"));
					readIngredient.setPoids(result.getInt("poids"));
				}
				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readIngredient;
		}

		public static ArrayList<Ingredient> readAllIngredient() {
			ArrayList<Ingredient> readIngredientList = new ArrayList<Ingredient>();
			try {
				String selectIngredientQuery = "SELECT * FROM ingredient ";
				Connection dbConnection = ConnectionDB.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Ingredient readIngredient = new Ingredient();
					readIngredient.setId_ingredient(result.getInt("id_ingredient"));
					readIngredient.setAlim_nom_fr(result.getString("alim_nom_fr"));
					readIngredient.setAlim_grp_code(result.getInt("alim_grp_code"));
					readIngredient.setAlim_ssgrp_code(result.getInt("alim_ssgrp_code"));
					readIngredient.setAlim_ssssgrp_code(result.getInt("alim_ssssgrp_code"));
					readIngredient.setPoids(result.getInt("poids"));

					readIngredientList.add(readIngredient);
				}
				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readIngredientList;
		}
		
		
		public static ArrayList<Ingredient> readIngredientWithLike(Ingredient ingredient) {
			ArrayList<Ingredient> readIngredientList = new ArrayList<Ingredient>();
			SystemUtility query = new SystemUtility();
			try {
				String selectIngredientQuery = query.createQuery(ingredient.getAlim_nom_fr());
				Connection dbConnection = ConnectionDB.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Ingredient readIngredient = new Ingredient();
					readIngredient.setId_ingredient(result.getInt("id_ingredient"));
					readIngredient.setAlim_nom_fr(result.getString("alim_nom_fr"));
					readIngredient.setAlim_grp_code(result.getInt("alim_grp_code"));
					readIngredient.setAlim_ssgrp_code(result.getInt("alim_ssgrp_code"));
					readIngredient.setAlim_ssssgrp_code(result.getInt("alim_ssssgrp_code"));
					readIngredient.setPoids(result.getInt("poids"));

					readIngredientList.add(readIngredient);
				}
				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readIngredientList;
		}
}
