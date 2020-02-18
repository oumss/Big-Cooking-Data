package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import core.MockCore;

@ManagedBean(name = "signinBean", eager = true)
@SessionScoped
public class SigninBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131931L;

	private String login;
	private String password;
	private String incorrect;
	private boolean connected = false;

	public SigninBean() {
	}

	public String verify() {
		String results;
		if (MockCore.exist(login)) {
			if (MockCore.isValid(login, password)) {
				results = "home";
				System.out.println("connected");
				connected = true;
			} else {
				results = "errorSignin";
				System.out.println("password incorrect");
			}
		} else {
			results = "errorSignin";
			System.out.println("login incorrect");
		}
		return results;
	}

	public String signout() {
		return "signout";
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(String incorrect) {
		this.incorrect = incorrect;
	}

}
