package beans;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import business.Recipe;
import ingredients.Cleaner;
import persistance.RecipePersistance;

@ManagedBean
@SessionScoped
public class ResultRecipeBean implements Serializable {

	@ManagedProperty(value = "#{resultBean}")
	private ResultBean resultBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private Recipe recipe;
	private String url;

	public ResultRecipeBean() {
		
	}

	@PostConstruct
	public void init() {
		int idRecipe = resultBean.getIdSelected();
		RecipePersistance rp = new RecipePersistance();
		this.recipe = rp.readRecipeById(idRecipe);
		
	}
	
	public String affiche(int idFromR) {
		Cleaner clean = new Cleaner();
		int idRecipe = idFromR;
		System.out.println(idRecipe);
		String newSteps = clean.cleanSteps(idRecipe);
		RecipePersistance rp = new RecipePersistance();
		System.out.println(newSteps);
		
		this.setUrl(verifUrlForImage(idRecipe));
	
		this.recipe = rp.readRecipeById(idRecipe);
		this.recipe.setSteps(newSteps);
		System.out.println(recipe.getIngredientsList());
		
		
		return "resultRecipe";
	
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
	
	public ResultBean getResultBean() {
		return resultBean;
	}

	public void setResultBean(ResultBean resultBean) {
		this.resultBean = resultBean;
	}

	public Recipe getRecipe() {
		return recipe;
	} 

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
