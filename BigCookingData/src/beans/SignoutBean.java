package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.User;
import persistance.UserPersistance;

@ManagedBean
@SessionScoped
public class SignoutBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131931L;

	private String login;
	private String password;
	private String email;
	private String confirmedPassword;
	private String firstname;
	private String surname;

	public SignoutBean() {
	}

	public String create() {
		System.out.println(login);
		System.out.println(password);
		System.out.println(email);
		System.out.println(confirmedPassword);
		System.out.println(firstname);
		System.out.println(surname);
		String results;
		UserPersistance userPersist = new UserPersistance();
		User usr = userPersist.readUserByLogin(login);
		    if (usr == null) {
	            if (this.password == this.confirmedPassword && verifNotNull(this.login, this.password, this.email, this.confirmedPassword, this.firstname, this.surname)) {
	            	results = "signin";
	            	userPersist.CreateUser(this.firstname, this.surname, this.login, this.password);
	                System.out.println("Succes insert BDD");
	            } else {
	            	
	                results = "errorSignoutNotSamePass";
	                System.out.println("password incorrect");
	            }
		} else {
			results = "errorSignoutLoginAlreadyUsed";
			System.out.println("login already used");
		}
		return results;
	}

	
	
	public boolean verifNotNull(String login, String password, String email, String confirmedPassword, String firstname,String surname ) {
		if (login!=null && password!=null && email!=null && confirmedPassword!=null && firstname!=null && surname!=null)
		return true;
		else
			return false;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
