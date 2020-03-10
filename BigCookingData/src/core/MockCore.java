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
			if (usertmp.getLogin().equals(login)) {
				// System.out.println(login +" "+ usertmp.getLogin() );
				return usertmp;
			}
		}
		return user;
	}

}
