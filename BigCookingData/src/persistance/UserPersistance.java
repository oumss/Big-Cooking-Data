package persistance;

import java.util.ArrayList;
import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPersistance {

	public User readUserById(int id) {
		User readUser = new User();
		try {
			String selectUserQuery = "SELECT * FROM user WHERE id_user = ? ";
			Connection dbConnection = ConnectionDB.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				readUser.setId(result.getInt("id_user"));
				readUser.setLogin(result.getString("login"));
				readUser.setPassword(result.getString("password"));
				readUser.setSurname(result.getString("surname"));
				readUser.setFirstname(result.getString("firstname"));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readUser;
	}
	
	public User readUserByLogin(int id) {
		User readUser = new User();
		try {
			String selectUserQuery = "SELECT * FROM user WHERE login = ? ";
			Connection dbConnection = ConnectionDB.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				readUser.setId(result.getInt("id_user"));
				readUser.setLogin(result.getString("login"));
				readUser.setPassword(result.getString("password"));
				readUser.setSurname(result.getString("surname"));
				readUser.setFirstname(result.getString("firstname"));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readUser;
	}

	public static ArrayList<User> readAllUser() {
		ArrayList<User> readUserList = new ArrayList<User>();
		try {
			String selectUserQuery = "SELECT * FROM user ";
			Connection dbConnection = ConnectionDB.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				User readUser = new User();
				readUser.setId(result.getInt("id_user"));
				readUser.setLogin(result.getString("login"));
				readUser.setPassword(result.getString("password"));
				readUser.setSurname(result.getString("surname"));
				readUser.setFirstname(result.getString("firstname"));

				readUserList.add(readUser);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return readUserList;
	}
}