package core;

public class SearchEntry {

	private String keyword;
	private String[] selectedCategories;

	public SearchEntry(String keyword, String[] selectedCategories) {
		super();
		this.keyword = keyword;
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

	public String[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
}
