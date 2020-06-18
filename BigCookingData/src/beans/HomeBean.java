package beans;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.Recipe;
import persistance.ConnexionPersistence;
import persistance.RecipePersistance;

@ManagedBean(name = "homeBean", eager = true)
@SessionScoped
public class HomeBean implements Serializable {

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;
	private static final long serialVersionUID = 6955508471291131931L;
	public List<Recipe> recipesFinal ;
	
	
	public HomeBean() {
	}

	 public List<Recipe> imagesView() {
		 	int i = 0; 
	    	RecipePersistance rp = new RecipePersistance();
	    	List<Recipe> recipes;
	    	List<Recipe> recipes2 = new ArrayList<Recipe>();
	    	recipes = rp.selectByKeyWordForLearning("");
	    	System.out.println(recipes.toString());
	    	 
	        while ((i < recipes.size()) && (i < 10)) {
	        	
	        	recipes2.add(recipes.get(i)); 
	            i++;
	        }
	        this.setRecipesFinal(recipes2);
	        return recipesFinal;
	    }
	 public String action(int id) {
		 ResultRecipeBean r = new ResultRecipeBean();
		 return  r.affiche(id);
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
	public List<Recipe> getRecipesFinal(List<Recipe> recipesFinal) {
		return recipesFinal;
	}

	public void setRecipesFinal(List<Recipe> recipesFinal) {
		this.recipesFinal = recipesFinal;
	}
}
