package persistance;

import java.util.ArrayList;
import business.Ingredient;
import clean.SystemUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientPersistance {

	private Connection dbConnection;

	public IngredientPersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public Ingredient readIngredientById(int id) {
		Ingredient readIngredient = new Ingredient();
		try {
			String selectIngredientQuery = "SELECT * FROM ingredient WHERE id_ingredient = ? ";
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

	public ArrayList<Ingredient> readAllIngredient() {
		ArrayList<Ingredient> readIngredientList = new ArrayList<Ingredient>();
		try {
			String selectIngredientQuery = "SELECT * FROM ingredient ";
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

	public ArrayList<Ingredient> readIngredientWithLike(Ingredient ingredient) {
		ArrayList<Ingredient> readIngredientList = new ArrayList<Ingredient>();
		SystemUtility query = new SystemUtility();
		try {
			String selectIngredientQuery = query.createQuery(ingredient.getAlim_nom_fr());
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

		if (readIngredientList.size() == 0) {
			try {
				String selectIngredientQuery = query.createQueryWithOr(ingredient.getAlim_nom_fr());
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

		}
		return readIngredientList;
	}
	
	
	
	
	
	public ArrayList<Integer> readAllSousCategorie() {
		ArrayList<Integer> readSousCategorieList = new ArrayList<Integer>();
		try {
			String selectIngredientQuery = "SELECT DISTINCT alim_ssgrp_code FROM ingredient ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				int a = result.getInt("alim_ssgrp_code");
				readSousCategorieList.add(a);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readSousCategorieList;
	}
	
	
	
	public ArrayList<Ingredient> readIngredientsBySousCategorie(int categorieCode) {
		ArrayList<Ingredient> readIngredientList = new ArrayList<Ingredient>();
		try {
			String selectIngredientQuery = "SELECT * FROM ingredient WHERE alim_ssgrp_code = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			preparedStatement.setInt(1, categorieCode);
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
	
	
	public ArrayList<String> readAllSousCategorieNames() {
		ArrayList<String> readSousCategorieList = new ArrayList<String>();
		try {
			String selectIngredientQuery = "SELECT DISTINCT alim_ssgrp_code FROM ingredient ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectIngredientQuery);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				String a = result.getString("alim_ssgrp_nom_fr");
				readSousCategorieList.add(a);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readSousCategorieList;
	}
	
}
