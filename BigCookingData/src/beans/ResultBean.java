package beans;

import java.io.Serializable;

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
	public ResultBean() {
	}

	@PostConstruct
	public void init() {
		recipes.addAll(searchBean.getRecipes());
		System.out.println(recipes.size());
	}
	
	public  String select(String id) {
		System.out.println(id);
		setIdSelected(Integer.valueOf(id));
		return "";
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

}
