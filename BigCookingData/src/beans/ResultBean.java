package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.PrimeFaces;
import org.primefaces.event.UnselectEvent;

import com.sun.tracing.dtrace.NameAttributes;

import business.Recipe;
import core.SearchEntry;
import core.SearchRecipe;
import persistance.RecipePersistance;

@ManagedBean
@SessionScoped
public class ResultBean implements Serializable {

	@ManagedProperty(value = "#{searchBean}")
	private SearchBean searchBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

	public ResultBean() {
	}

	@PostConstruct
	public void init() {
		//recipes.addAll(searchBean.getRecipes());
		System.out.println(recipes.size());
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

}
