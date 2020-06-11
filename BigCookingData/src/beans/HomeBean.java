package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import persistance.ConnexionPersistence;

@ManagedBean(name = "homeBean", eager = true)
@SessionScoped
public class HomeBean implements Serializable {

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;
	private static final long serialVersionUID = 6955508471291131931L;

	public HomeBean() {
	}

	
	public String disconnect() {
		signinBean.setConnected(false);
		ConnexionPersistence connPers = new ConnexionPersistence();
        connPers.updateWhoConnected(0);
		return "signin";
	}

	public SigninBean getSigninBean() {
		return signinBean;
	}

	public void setSigninBean(SigninBean signinBean) {
		this.signinBean = signinBean;
	}

}
