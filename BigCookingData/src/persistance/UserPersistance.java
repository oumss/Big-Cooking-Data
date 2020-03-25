package persistance;

import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class UserPersistance {

	private Connection dbConnection;

	public UserPersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public User readUserById(int id) {
		User readUser = new User();
		try {
			String selectUserQuery = "SELECT * FROM user WHERE id_user = ? ";
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

	public User readUserByLogin(String login) {
		User readUser = new User();
		try {
			String selectUserQuery = "SELECT * FROM user WHERE login = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setString(1, login);
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
	
	

	public ArrayList<User> readAllUser() {
		ArrayList<User> readUserList = new ArrayList<User>();
		try {
			String selectUserQuery = "SELECT * FROM user ";
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
	public void CreateUser(String surname, String firstname, String login, String password) {
		
	
		try {
			
			String selectUserQuery = "SELECT COUNT(*) FROM user";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			ResultSet result = preparedStatement.executeQuery();
			preparedStatement.close();
			
			
			
			java.sql.Statement addStatement = dbConnection.createStatement();
			addStatement.executeUpdate("INSERT INTO `bcd`.`user` (`id_user`,`surname`,`firstname`,`login`,`password`) VALUES (" + result+1 + ",'" + surname + "','"+ firstname +"','"+ login +"','" + password + "')");
			addStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
}