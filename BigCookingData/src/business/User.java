package business;

public class User {

	private int id;
	private String login;
	private String password;
	private String surname;
	private String firstname;

	public User() {
	}

	public User(int id, String login, String password, String surname, String firstname) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.surname = surname;
		this.firstname = firstname;
	}

	public boolean isCorrectPassword(String password) {
		if ((this.password).equals(password)) {
			return true;
		}
		return false;
	}
	
	public boolean isCorrectLogin(String login) {
		if ((this.login).equals(login)) {
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
