package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import core.MockCore;

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
		String results = "errorPassword";
		String loginPassword = MockCore.getUserByLogin(signinBean.getLogin()).getPassword();
		System.out.println("loginpass = "+loginPassword +" atcual = "+actualPassword+" new = "+newPassword+" conf = "+confirmedPassword);
		
		if (actualPassword.equals(loginPassword)) {
			if (newPassword.equals(confirmedPassword)) {
				results = "sucessPassword";
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
