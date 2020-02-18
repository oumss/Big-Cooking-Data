package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "searchBean", eager = true)
@SessionScoped
public class SearchBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131930L;

	public SearchBean() {
	}

	public String search() {
		return "results";
	}

}
