package core;

public class SearchRecipe {

	private SearchEntry entry;

	public SearchRecipe() {
	}

	public SearchRecipe(SearchEntry entry) {
		super();
		this.entry = entry;
	}

	public SearchEntry getEntry() {
		return entry;
	}
	public void setEntry(SearchEntry entry) {
		this.entry = entry;
	}
}
