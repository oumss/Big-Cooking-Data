package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "searchBean", eager = true)
@SessionScoped //sessionScoped=les choses sont utilisable que lorsque que le client est identifie, applicationScoped=qd l'application est tjrs ouverte els choses sont utilisables , requestScoped=les requetes du protocole http, viewScoped=qd la page web est tjrs affcihé on peut encore utiliser si la page est fermé alors non 
public class SearchBean implements Serializable {

	/**
	 * A session scoped bean must be serializable.
	 */
	private static final long serialVersionUID = 6955508471291131930L;
	//private SearchEntry entry = new SearchEntry();

	public SearchBean() {
	}

	public String search() {
		//System.out.println(entry.getKeyword() + entry.getComfort() + entry.getBudget() + entry.getType());
		return "results";
	}


}
