package business;

public class Ingredient {

	private int id;
	private String name;
	private int quantity;
	public enum Unit {kG,mG,G,cL,mL,L,U,cac,cas};
	private Unit unit ; 
	
	public Ingredient(int id, String name, int quantity,Unit unit) {
		super();
		this.id = id;
		this.name = name;
		this.quantity=quantity;
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
}
