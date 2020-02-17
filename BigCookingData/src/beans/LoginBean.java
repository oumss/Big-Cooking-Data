package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import core.MockCore;

@ManagedBean(name = "loginBean", eager = true)
@SessionScoped 
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131931L;

	private String login;
	private String password;
	private boolean connected = false;
	
	public LoginBean() {
	}
	
	public String verify() {
		String results;
		if (MockCore.exist(login)) {
			if (MockCore.isValid(login, password)) {
				results = "home";
				System.out.println("connected");
				connected = true;
			} else {
				results = "login";
				System.out.println("password incorrect");
			}
		} else {
			results = "login";
			System.out.println("login incorrect");
		}
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
}
