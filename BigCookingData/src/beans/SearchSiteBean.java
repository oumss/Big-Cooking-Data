package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.Hotel;
import business.Site;

@ManagedBean(name = "searchSiteBean", eager = true)
@SessionScoped
public class SearchSiteBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131930L;
	private String name;
	private String adress;
	private String price;
	private String type;
	private String isle;
	private String max;
	private String min;
	private ArrayList<Site> sites = new ArrayList<Site>();

	public SearchSiteBean() {
	}

	@PostConstruct
	public void init() {
		name = "";
		type = "";
		price = "";
		isle = "";
		max = "9999";
		min = "0";
	}

	public String searchSite() {
		System.out.println(max + " " + min);
		String query;
		if (name == "") {
			if (type == "") {
				query = "select * from site where site_price > " + min + " and site_price < " + max;
			}
			else {
				query = "select * from site where site_price > " + min + " and site_price < " + max+ " and type = '" + type+"'";
			}
		} else {
			query = "select * from site where site_price > " + min + " and site_price < " + max + " and name='" + name + "'";

		}
		System.out.println("resultSite query = " + query);
		//sites.addAll(SearchSite.operatorSQL(query));
		System.out.println("resultSiteBean sites = " + sites);
		return "resultSite";
	}

	public ArrayList<Site> getSites() {
		return sites;
	}

	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsle() {
		return isle;
	}

	public void setIsle(String isle) {
		this.isle = isle;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

}
