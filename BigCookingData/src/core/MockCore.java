package core;

import java.util.ArrayList;

import business.Ingredient;
import business.Recipe;
import business.User;

/**
 * A utility class for providing data simulation (act as a simple database).
 * 
 */
public class MockCore {
	
	private static final ArrayList<User> userRegistry = new ArrayList<User>();
	static {
		userRegistry.add(new User(0, "user1", "aaa"));
		userRegistry.add(new User(1, "user2", "bbb"));
	}

	private static final ArrayList<Ingredient> ingredients0 = new ArrayList<Ingredient>();
	static {
		ingredients0.add(new Ingredient(0,"tomate"));
		ingredients0.add(new Ingredient(1,"oignon"));
		ingredients0.add(new Ingredient(2,"kefta"));		
	}
	
	private static final ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
	static {
		ingredients1.add(new Ingredient(3,"viande"));
		ingredients1.add(new Ingredient(4,"carrote"));
		ingredients1.add(new Ingredient(0,"tomate"));
		ingredients1.add(new Ingredient(1,"oignon"));
		ingredients1.add(new Ingredient(5,"huile d'olive"));		
	}

	private static final ArrayList<Recipe> recipeRegistry = new ArrayList<Recipe>();
	static {
		recipeRegistry.add(new Recipe(0,"Tcharmira", ingredients0));
		recipeRegistry.add(new Recipe(1,"Tagine", ingredients1));
	}
	
	public static boolean exist(String login) {
		User user = getUserByLogin(login);
		return userRegistry.contains(user);
	}

	public static boolean isValid(String login, String password) {
		boolean result = false;
		User user = getUserByLogin(login);
		if (userRegistry.contains(user)) {
			String expectedPassword = userRegistry.get(user.getId()).getPassword();
			if (expectedPassword.equals(password)) {
				result = true; 
			}
		}
		return result;
	}
	
	public static User getUserByLogin(String login) {
		User user = null;
		for (User usertmp : userRegistry) {
			if(usertmp.getLogin().equals(login)) {
				//System.out.println(login +" "+ usertmp.getLogin() );
				return usertmp;
			}
		}
		return user;
	}

}
