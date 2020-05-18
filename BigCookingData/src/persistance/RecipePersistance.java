package persistance;

import java.util.ArrayList;
import business.Recipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipePersistance {

	private Connection dbConnection;
	
	public RecipePersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public Recipe readRecipeById(int id) {
		Recipe readRecipe = new Recipe();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE id_recipe = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();
			
			while (result.next()) {
				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setUrl(result.getString("url"));
				readRecipe.setNumberOfPerson(result.getInt("number_of_person"));
				readRecipe.setIngredientsList(result.getString("ingredients_list"));
				readRecipe.setUstensilsList(result.getString("utensils"));
				readRecipe.setTitle(result.getString("title"));
				readRecipe.setBudget(result.getInt("budget"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setLevel(result.getInt("level"));
				readRecipe.setTimeCooking(result.getString("time_cooking"));
				readRecipe.setTimeTotal(result.getString("time_total"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(id));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(" hoy "+se.getMessage());
		}

		return readRecipe;
	}

	public ArrayList<Recipe> readAllRecipe() {
		ArrayList<Recipe> readRecipeList = new ArrayList<Recipe>();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();			

			while (result.next()) {
				Recipe readRecipe = new Recipe();

				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setUrl(result.getString("url"));
				readRecipe.setNumberOfPerson(result.getInt("number_of_person"));
				readRecipe.setIngredientsList(result.getString("ingredients_list"));
				readRecipe.setUstensilsList(result.getString("utensils"));
				readRecipe.setTitle(result.getString("title"));
				readRecipe.setBudget(result.getInt("budget"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setLevel(result.getInt("level"));
				readRecipe.setTimeCooking(result.getString("time_cooking"));
				readRecipe.setTimeTotal(result.getString("time_total"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(readRecipe.getId()));

				readRecipeList.add(readRecipe);
				System.out.println(readRecipe.getTitle());
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println("hey"+se.getMessage());
		}
		return readRecipeList;
	}

	public Recipe readRandRecipe() {
		Recipe readRecipe = new Recipe();
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE RAND() > 0.9 ORDER BY RAND( ) LIMIT 1 ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();

			while (result.next()) {
				
				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setUrl(result.getString("url"));
				readRecipe.setNumberOfPerson(result.getInt("number_of_person"));
				readRecipe.setIngredientsList(result.getString("ingredients_list"));
				readRecipe.setUstensilsList(result.getString("utensils"));
				readRecipe.setTitle(result.getString("title"));
				readRecipe.setBudget(result.getInt("budget"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setLevel(result.getInt("level"));
				readRecipe.setTimeCooking(result.getString("time_cooking"));
				readRecipe.setTimeTotal(result.getString("time_total"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(readRecipe.getId()));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return readRecipe;
	}
	
	
	
	
	
	
	
	public ArrayList<Recipe> selectByKeyWord(String cat) {
		
		ArrayList<Recipe> listRecette = new ArrayList<Recipe>();
		ArrayList<Recipe> listStr = new ArrayList<Recipe>();
		int i = 0;
		int j = 0;
		try {
			String selectRecipeQuery = "SELECT * FROM recipe WHERE category LIKE ? OR title LIKE ? OR ingredients_list LIKE ?";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRecipeQuery);
			preparedStatement.setString(1, "%" + cat + "%");
			preparedStatement.setString(2, "%" + cat + "%");
			preparedStatement.setString(3, "%" + cat + "%");
			ResultSet result = preparedStatement.executeQuery();
			IngredientRecipePersistance ingredientRecipePersist = new IngredientRecipePersistance();

			while (result.next()) {
				
				Recipe readRecipe = new Recipe();

				
				readRecipe.setId(result.getInt("id_recipe"));
				readRecipe.setUrl(result.getString("url"));
				readRecipe.setNumberOfPerson(result.getInt("number_of_person"));
				readRecipe.setIngredientsList(result.getString("ingredients_list"));
				readRecipe.setUstensilsList(result.getString("utensils"));
				readRecipe.setTitle(result.getString("title"));
				readRecipe.setBudget(result.getInt("budget"));
				readRecipe.setCategory(result.getString("category"));
				readRecipe.setLevel(result.getInt("level"));
				readRecipe.setTimeCooking(result.getString("time_cooking"));
				readRecipe.setTimeTotal(result.getString("time_total"));
				readRecipe.setSteps(result.getString("steps"));
				readRecipe.setIngredientsMap(ingredientRecipePersist.readIngredientByIdRecipe(readRecipe.getId()));
				
				listRecette.add(readRecipe);
			//	System.out.println(listRecette.get(i).getName());
			//	i++;
			}
			
			

			preparedStatement.close();


		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	//	System.out.println(listRecette.toString());
		
	/*	for (Recipe recipe : listRecette) {
			System.out.println(recipe.getId());
		} */
			
		
		
		return listRecette;
		
	}
	
}