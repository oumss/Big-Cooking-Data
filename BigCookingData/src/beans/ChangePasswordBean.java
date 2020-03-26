package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.User;
import core.MockCore;
import persistance.UserPersistance;

@ManagedBean
@SessionScoped
public class ChangePasswordBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131931L;

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;

	private String actualPassword;
	private String newPassword;
	private String confirmedPassword;

	public ChangePasswordBean() {
	}

	public String verify() {
		UserPersistance userPersist = new UserPersistance();
		User usr = userPersist.readUserByLogin(signinBean.getLogin());
		String results = "errorPassword";
		//System.out.println("loginpass = " + loginPassword + " atcual = " + actualPassword + " new = " + newPassword + " conf = " + confirmedPassword);

		if (usr.isCorrectPassword(actualPassword)) {
			if (newPassword.equals(confirmedPassword)) {
				userPersist.UpdatePassword(usr.getLogin(), newPassword);
				results = "sucessPassword";
				System.out.println("Password updating: Succes");
			}
		}
		return results;
	}

	public String getActualPassword() {
		return actualPassword;
	}

	public void setActualPassword(String actualPassword) {
		this.actualPassword = actualPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public SigninBean getSigninBean() {
		return signinBean;
	}

	public void setSigninBean(SigninBean signinBean) {
		this.signinBean = signinBean;
	}

}
