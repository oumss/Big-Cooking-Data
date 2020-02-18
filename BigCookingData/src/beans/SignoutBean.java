package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import core.MockCore;

@ManagedBean(name = "signoutBean", eager = true)
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
		String results = "signin";
		return results;
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
