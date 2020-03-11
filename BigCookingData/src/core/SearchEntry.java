package core;

public class SearchEntry {

	private String keyword;
	private String ingredients;
	private String[] selectedCategories;

	public SearchEntry(String keyword, String ingredients, String[] selectedCategories) {
		super();
		this.keyword = keyword;
		this.ingredients = ingredients;
		this.selectedCategories = selectedCategories;
	}

	public void combineEntry() {
		
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
}
