package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.event.UnselectEvent;

import business.Recipe;
import core.SearchEntry;
import persistance.ConnexionPersistence;
import persistance.RecipePersistance;
import testLearnPerceptron.Perceptron;

@ManagedBean(name = "searchBean", eager = true)
@SessionScoped
public class SearchBean implements Serializable {

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private String keyword;
	private String category;
	private List<SelectItemGroup> categories;
	private String selectedCategories;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public SearchBean() {
	}

	@PostConstruct
	public void init() {

		categories = new ArrayList<SelectItemGroup>();
		SelectItemGroup cat = new SelectItemGroup("Catégories");
		cat.setSelectItems(new SelectItem[] {new SelectItem("", "Select One"), new SelectItem("Entrée", "Entrée"), new SelectItem("Plat", "Plat"),
				new SelectItem("Dessert", "Dessert"), new SelectItem("Soupe", "Soupe"),
				new SelectItem("Apéritif", "Apéritif"), new SelectItem("Boisson", "Boisson") });
		categories.add(cat); 
	}

	public String search() {
		System.out.println("yooooooooooooooooooooo");
		this.recipes = new ArrayList<Recipe>();
		
		RecipePersistance recipePersist = new RecipePersistance();
		System.out.println(recipes.toString());
		System.out.println("yooooooooooooooooooooo");
		try {
			System.out.println(selectedCategories);
			recipes.addAll(recipePersist.selectByKeyWordPlusCategory(keyword,selectedCategories));
			System.out.println(selectedCategories);
			System.out.println("Key + Categorie");
			
		} catch (Exception e) {
			recipes.addAll(recipePersist.selectByKeyWord(keyword));
			System.out.println("pas rempli");
			System.out.println("que le key");
		}
			
			System.out.println(recipes.toString());
		//	System.out.println(selectedCategories[0]);
			

		
		
		return "results";
	}
	
	public String selectedCategoriesFunc() {
		if(this.selectedCategories.equals("")) {
			return "";
		}
		else {
			return "(Catégorie: ''" + this.selectedCategories +"'')";
		}
			
	}
	
	public String quickSearch(String cat) {
		
		this.recipes = new ArrayList<Recipe>();
		RecipePersistance recipePersist = new RecipePersistance();
		System.out.println(recipes.toString());
		recipes.addAll(recipePersist.selectByKeyWord(cat));
		System.out.println(recipes.toString());
		
		
		
		return "results";
	}
	
	public void newCategory(String cat) {
		
		
	}
	

	public ArrayList<Recipe> searchForLearning() {
		
		Perceptron p = new Perceptron();
		ConnexionPersistence conn = new ConnexionPersistence();
		
		return p.proposition(conn.whoIsConnected().getId());
	}

	public String disconnect() {
		signinBean.setConnected(false);
		return "signin";
	}

	public String getKeyword() {
		return keyword;
	}
 
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public SigninBean getSigninBean() {
		return signinBean;
	}

	public void setSigninBean(SigninBean signinBean) {
		this.signinBean = signinBean;
	}

	public List<SelectItemGroup> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItemGroup> categories) {
		this.categories = categories;
	}

	public String getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String selectedCategories) {
		this.selectedCategories = selectedCategories;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public void onItemUnselect(UnselectEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage();
		msg.setSummary("Item unselected: " + event.getObject().toString());
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		context.addMessage(null, msg);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
