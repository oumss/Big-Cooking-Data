package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import core.MockCore;

@ManagedBean
@SessionScoped 
public class HomeBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131931L;

	private String keyword;
	
	public HomeBean() {
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
