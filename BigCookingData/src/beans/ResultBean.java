package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.Site;

@ManagedBean 
@SessionScoped 
public class ResultBean implements Serializable {

	
	@ManagedProperty(value = "#{searchBean}")
	private SearchBean searchBean ;
	private static final long serialVersionUID = 6955508471291131930L;
	//private SearchOffer searchOffer;
	private HashMap<Integer, ArrayList<Site>> sites = new HashMap<Integer, ArrayList<Site>>();

	public ResultBean() {
	}

	@PostConstruct
	public void init() {
		//System.out.println("resultsbean :"+searchBean.getEntry().getKeyword() + searchBean.getEntry().getComfort() + searchBean.getEntry().getBudget() + searchBean.getEntry().getType());
	//	searchOffer = new SearchOffer(searchBean.getEntry());
		//System.out.println("calcul");
		//System.out.println("offers =" + searchOffer.getOffers());
	//	sites.putAll(searchOffer.getSites());
		//System.out.println("sites =" + sites);
	}
	
	public SearchBean getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}

	public HashMap<Integer, ArrayList<Site>> getSites() {
		return sites;
	}

	public void setSites(HashMap<Integer, ArrayList<Site>> sites) {
		this.sites = sites;
	}
	

}
