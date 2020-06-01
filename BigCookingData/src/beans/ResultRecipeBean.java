package beans;

import java.io.Serializable;

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
		
	
		this.recipe = rp.readRecipeById(idRecipe);
		this.recipe.setSteps(newSteps);
		System.out.println(recipe.getIngredientsList());
		
		
		return "resultRecipe";
	
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

}
