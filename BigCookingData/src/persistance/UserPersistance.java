package persistance;

import java.util.ArrayList;




import business.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


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
			
			String sql  = "SELECT * FROM user"; 
			java.sql.Statement addStatement = dbConnection.createStatement(); 
			ResultSet resultat = addStatement.executeQuery(sql); 
			int nColumns = 0;
			while (resultat.next())
			{
				nColumns++;
			}
			addStatement.close();
			
			System.out.println("Number of columns in user before update:" + nColumns);
			if (nColumns != 0) {
				nColumns = 100001+nColumns;  // Ne pas �tre surpris par le nombre 100001
			}else {							 // C'est juste pcq un id � 6 chiffres plus styl� masha Allah
				nColumns = 100001;			 // Et le 1 c'est pour ne pas commenc� � 0 en unit� in sha Allah
			}
			
			System.out.println("Number of columns in user after update:" + nColumns);
			
			java.sql.Statement addStatement2 = dbConnection.createStatement();
			addStatement2.executeUpdate("INSERT INTO `user` (`id_user`,`surname`,`firstname`,`login`,`password`) VALUES (" + nColumns + ",'" + surname + "','"+ firstname +"','"+ login +"','" + password + "')");

		} catch (SQLException se) {  
			System.err.println(se.getMessage());
		}
		
	}
	
	public void UpdatePassword(String login, String password) {

		try {
			
			java.sql.Statement addStatement = dbConnection.createStatement();
			addStatement.executeUpdate("UPDATE user SET password ='" + password + "' WHERE login ='" + login +"';");
		
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		
	}
	public boolean userExistByLogin(String login) {
		int nColumns=0;
		boolean bool = true;
			try {
			
				String selectUserQuery = "SELECT * FROM user WHERE login = ? ";
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
				preparedStatement.setString(1, login);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					nColumns++;
				}
				preparedStatement.close();
			
					
					if (nColumns != 0) {
						bool= true;
					}else {
						bool= false;
					}
			
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return bool;
	}
}