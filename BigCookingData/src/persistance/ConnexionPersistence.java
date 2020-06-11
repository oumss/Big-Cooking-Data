package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.User;

public class ConnexionPersistence {

	private Connection dbConnection;

	public ConnexionPersistence() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public ArrayList<String> readConnexionByIdRecipe(User user) {
		int id_user = user.getId();
		ArrayList<String> dates = new ArrayList<String>();
		try {
			String selectUserQuery = "SELECT * FROM connexion WHERE id_user = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, id_user);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				dates.add(result.getString("date"));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return dates;
	}
	
	public void updateWhoConnected(int idUser) {
		
		int login = idUser;
		
		if (login == 0) {
			
			try {
				
				java.sql.Statement addStatement = dbConnection.createStatement();
				addStatement.executeUpdate("UPDATE `connexion` SET `tmp`=1,`id_user`= null WHERE 1;");
				System.out.println("Deconnexion succes");
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
				
		}
		else {
		try {
			
			java.sql.Statement addStatement = dbConnection.createStatement();
			addStatement.executeUpdate("UPDATE `connexion` SET `tmp`=1,`id_user`="+ login +" WHERE 1;");
			System.out.println("USER:" + login + " is now connected");
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		}
	}
	
	public User whoIsConnected() {
		User readUser = new User();
		try {
			String selectUserQuery = "SELECT * FROM connexion ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectUserQuery);
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next()) {
				
				readUser.setId(result.getInt("id_user"));
				
				
			}
			
			
			preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
		
		return readUser;
		
		}
}