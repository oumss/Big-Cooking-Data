package business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistance.ConnectionDB;
import persistance.UserPersistance;
import business.*;
public class User {

	private int id;
	private String login;
	private String password;
    private String  surname;
    private String firstname; 

	public User(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	

	public User(int id, String login, String password, String surname, String firstname) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.surname = surname;
		this.firstname = firstname;
	}

	public User() {
	}
	
	public boolean  auth_user (String password) {
		
		if((this.password).equals(password)) {
			return true;
		}
		return false;
	}
		
		
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
}
