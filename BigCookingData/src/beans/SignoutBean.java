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
		    if (usr.isCorrectLogin(login)) {
		    	results = "errorSignoutLoginAlreadyUsed";
				System.out.println("login already used");
		    } else {
		    	
		    	if (password.equals(confirmedPassword)) {
		    		results = "signin";
            		userPersist.CreateUser(surname, firstname, login, password);
            		System.out.println("Succes insert BDD");
		    	} else {
            	
		    		results = "errorSignoutNotSamePass";
		    		System.out.println("password incorrect");
		    	}
		    }
		return results;
	}

	
	
	public boolean verifNotNull(String login, String password, String email, String confirmedPassword, String firstname,String surname ) {
		if (this.login!=null && this.password!=null && this.email!=null && this.confirmedPassword!=null && this.firstname!=null && this.surname!=null) {
		return true;}
		else {
			return false;
		}
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
