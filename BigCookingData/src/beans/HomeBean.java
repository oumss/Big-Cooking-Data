package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import core.MockCore;

@ManagedBean
@SessionScoped 
public class HomeBean implements Serializable {

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private String keyword;
	
	public HomeBean() {
	}
	
	public String disconnect() {
		signinBean.setConnected(false);
		return "signin";
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public SigninBean getSigninBean() {
		return signinBean;
	}

	public void setSigninBean(SigninBean signinBean) {
		this.signinBean = signinBean;
	}
	
}
