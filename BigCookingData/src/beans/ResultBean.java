package beans;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.Recipe;

@ManagedBean(name = "resultBean", eager = true)
@SessionScoped
public class ResultBean implements Serializable {

	@ManagedProperty(value = "#{searchBean}")
	private SearchBean searchBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	private int idSelected;
	private String url = "";
	public ResultBean() {
	}

	@PostConstruct
	public void init() {
		System.out.println(recipes.toString());
		this.recipes = new ArrayList<Recipe>();
		System.out.println(recipes.toString());
		recipes.addAll(searchBean.getRecipes());
		System.out.println(recipes.toString());
		System.out.println(recipes.size());
	}
	
	public ArrayList<Recipe> funcRecipes () {
		System.out.println(recipes.toString());
		ArrayList<Recipe> recipesList = new ArrayList<Recipe>();
		System.out.println(recipesList.toString());
		recipesList.addAll(searchBean.getRecipes());
		System.out.println(recipesList.toString());
		System.out.println(recipesList.size());
		return recipesList;
	}
	
	public  String select(String id) {
		System.out.println(id);
		setIdSelected(Integer.valueOf(id));
		return "";
	}
	
	public String verifUrlForImage(int id) {
		
		  String urlToReturn = "";
	      URL uneURL=null;
	      
	      try {
	        uneURL = new URL("http://localhost/images/" + String.valueOf(id) + ".jpg");
	        HttpURLConnection connexion = (HttpURLConnection)uneURL.openConnection();
	        InputStream flux = connexion.getInputStream();
	        System.out.println("Status de la connexion : " + connexion.getResponseMessage());
	        if (connexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        urlToReturn = "http://localhost/images/" + String.valueOf(id) + ".jpg";
	        System.out.println(urlToReturn);}
	        flux.close(); 
	        connexion.disconnect();
	        
	      } 
	      catch(Exception e) {
	          
	    	  urlToReturn = "./images/default.jpg";
	          System.out.println(urlToReturn);
	      }
	      return urlToReturn;
	}
	
	public SearchBean getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public int getIdSelected() {
		return idSelected;
	}

	public void setIdSelected(int idSelected) {
		this.idSelected = idSelected;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
