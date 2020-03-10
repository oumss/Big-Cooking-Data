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

@ManagedBean(name = "searchBean", eager = true)
@SessionScoped
public class SearchBean implements Serializable {

	@ManagedProperty(value = "#{signinBean}")
	private SigninBean signinBean;
	private static final long serialVersionUID = 6955508471291131931L;
	private String keyword;
	private List<SelectItemGroup> ingredients;
	private String[] selectedIngredients;

	public SearchBean() {
	}

	@PostConstruct
	public void init() {

		ingredients = new ArrayList<SelectItemGroup>();

		SelectItemGroup legumes = new SelectItemGroup("Légumes");
		legumes.setSelectItems(
				new SelectItem[] { new SelectItem("Concombre", "Concombre"), new SelectItem("Tomate", "Tomate"),
						new SelectItem("Aubergine", "Aubergine"), new SelectItem("Pomme de terre", "Pomme de terre"),
						new SelectItem("Tomate", "Tomate"), new SelectItem("Oignon", "Oignon") });

		SelectItemGroup fruits = new SelectItemGroup("Fruits");
		fruits.setSelectItems(
				new SelectItem[] { new SelectItem("Cerise", "Cerise"), new SelectItem("Framboise", "Framboise"),
						new SelectItem("Fraise", "Fraise"), new SelectItem("Mangue", "Mangue"),
						new SelectItem("Ananas", "Ananas"), new SelectItem("Kiwi", "Kiwi") });

		ingredients.add(legumes);
		ingredients.add(fruits);
	}
	
	public String search() {
		return "home";
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

	public List<SelectItemGroup> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<SelectItemGroup> ingredients) {
		this.ingredients = ingredients;
	}

	public String[] getSelectedIngredients() {
		return selectedIngredients;
	}

	public void setSelectedIngredients(String[] selectedIngredients) {
		this.selectedIngredients = selectedIngredients;
	}

	public void onItemUnselect(UnselectEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage();
		msg.setSummary("Item unselected: " + event.getObject().toString());
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		context.addMessage(null, msg);
	}

	

}
