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
import persistance.RecipePersistance;

@ManagedBean(name = "searchBean", eager = true)
@SessionScoped
public class SearchBean implements Serializable {

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private String keyword;
	private List<SelectItemGroup> categories;
	private String[] selectedCategories;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public SearchBean() {
	}

	@PostConstruct
	public void init() {

		categories = new ArrayList<SelectItemGroup>();
		SelectItemGroup cat = new SelectItemGroup("Catégories");
		cat.setSelectItems(new SelectItem[] { new SelectItem("Entrée", "Entrée"), new SelectItem("Plat", "Plat"),
				new SelectItem("Dessert", "Dessert"), new SelectItem("Soupe", "Soupe"),
				new SelectItem("Apéritif", "Apéritif"), new SelectItem("Boisson", "Boisson") });
		categories.add(cat);
	}

	public String search() {
		SearchEntry searchEntry = new SearchEntry(keyword, selectedCategories);
		// ... traitement des entrées ...
		RecipePersistance recipePersist = new RecipePersistance();
		ArrayList<Recipe> recipesPersist = recipePersist.readAllRecipe();
		System.out.println("recipes = "+recipesPersist);
		recipes.addAll(recipesPersist);
		
		// recipes = ...
		return "results";
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

	public String[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String[] selectedCategories) {
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

}
