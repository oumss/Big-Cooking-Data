package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.Site;

@ManagedBean
@SessionScoped
public class ResultSiteBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131930L;

	@ManagedProperty(value = "#{searchSiteBean}")
	private SearchSiteBean searchSiteBean;

	private ArrayList<Site> sites = new ArrayList<Site>();

	public ResultSiteBean() {
	}

	@PostConstruct
	public void init() {
		sites.addAll(searchSiteBean.getSites());
	}

	public SearchSiteBean getSearchSiteBean() {
		return searchSiteBean;
	}

	public void setSearchSiteBean(SearchSiteBean searchSiteBean) {
		this.searchSiteBean = searchSiteBean;
	}

	public ArrayList<Site> getSites() {
		return sites;
	}

	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
	}

}
