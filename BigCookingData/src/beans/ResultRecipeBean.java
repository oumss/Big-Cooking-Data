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
import business.User;
import ingredients.Cleaner;
import testLearnPerceptron.*;
import persistance.ConnexionPersistence;
import persistance.DislikedRecipePersistence;
import persistance.LikedRecipePersistence;
import persistance.RecipePersistance;
import persistance.UserPersistance;

@ManagedBean
@SessionScoped
public class ResultRecipeBean implements Serializable {

	@ManagedProperty(value = "#{resultBean}")
	private ResultBean resultBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private Recipe recipe;
	private String url;
	private User usr;

	public ResultRecipeBean() {
		
	}

	@PostConstruct
	public void init() {
		int idRecipe = resultBean.getIdSelected();
		RecipePersistance rp = new RecipePersistance();
		this.recipe = rp.readRecipeById(idRecipe);
		 
		
	}
	
	public String success1(int idRecipe) {
		ConnexionPersistence conn = new ConnexionPersistence();
		int idUser = conn.whoIsConnected().getId();
		LikedRecipePersistence lk = new LikedRecipePersistence();
		if(lk.isLikedRecipeByUser(idUser, idRecipe)) {
			return "success1";
		}
		else {return "error";}
		
	}
	
	public String success2(int idRecipe) {
		ConnexionPersistence conn = new ConnexionPersistence();
		DislikedRecipePersistence dlk = new DislikedRecipePersistence();
		int idUser = conn.whoIsConnected().getId();
		if(dlk.isDislikedRecipeByUser(idUser, idRecipe)) {
			return "success2";
		}
		else {return "error";}
		
	}
	
	
	public String like(){
		LikedRecipePersistence lk = new LikedRecipePersistence();
		ConnexionPersistence conn = new ConnexionPersistence();
		int currentUsr = conn.whoIsConnected().getId();
		lk.addRecipe(currentUsr, this.recipe.getId());
		System.out.println(currentUsr +" a liké la recette:" + this.recipe.getId());
		Perceptron per = new Perceptron();
		per.apprentissage(currentUsr);
		
		return "";
	}
	
	public String dislike(){
		DislikedRecipePersistence dlk = new DislikedRecipePersistence();
		ConnexionPersistence conn = new ConnexionPersistence();

		int currentUsr = conn.whoIsConnected().getId();
		dlk.addRecipe(currentUsr, this.recipe.getId());
		System.out.println(currentUsr +" a disliké la recette:" + this.recipe.getId());
		Perceptron per = new Perceptron();
		per.apprentissage(currentUsr);
		
		return "";
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
		String newCategory = clean.cleanCategory(this.recipe.getCategory());
		String newUstensils = clean.cleanCategory(this.recipe.getUstensilsList());
		String newIngredient = clean.cleanIngredientList(this.recipe.getIngredientsList());

		this.recipe.setSteps(newSteps);
		this.recipe.setCategory(newCategory);
		this.recipe.setUstensilsList(newUstensils);
		this.recipe.setIngredientsList(newIngredient);
		
		System.out.println(recipe.getIngredientsList());
		
		
		
		return "resultRecipe";
	
	}
	
	public String affiche2(int idFromR) {
		Cleaner clean = new Cleaner();
		int idRecipe = idFromR;
		System.out.println(idRecipe);
		String newSteps = clean.cleanSteps(idRecipe);
		
		RecipePersistance rp = new RecipePersistance();
		System.out.println(newSteps);
		
		this.setUrl(verifUrlForImage(idRecipe));
	
		this.recipe = rp.readRecipeById(idRecipe);
		String newCategory = clean.cleanCategory(this.recipe.getCategory());
		String newUstensils = clean.cleanCategory(this.recipe.getUstensilsList());
		String newIngredient = clean.cleanIngredientList(this.recipe.getIngredientsList());

		this.recipe.setSteps(newSteps);
		this.recipe.setCategory(newCategory);
		this.recipe.setUstensilsList(newUstensils);
		this.recipe.setIngredientsList(newIngredient);
		
		System.out.println(recipe.getIngredientsList());
		
		
		
		return "resultRecipe2";
	
	}
	
	public String category(String category) {
		Cleaner clean = new Cleaner();
		return clean.cleanCategoryForHome(category);
	}
	
	public String budget(int budget) {
		Cleaner clean = new Cleaner();
		return clean.cleanBudget(budget);
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

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

}
