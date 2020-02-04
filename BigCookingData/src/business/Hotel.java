package business;

public class Hotel extends Place {

	private int id;
	private String name;
	private String isle;
	private int stars;
	private String adress;
	private int price;
	private Coordinate coordinate;

	public Hotel() {

	}

	public Hotel(int id, String name, int price, String isle, int star, String adress, Coordinate coordinate) {
		super();
		this.id = id;
		this.name = name;
		this.isle = isle;
		this.stars = star;
		this.adress = adress;
		this.price = price;
		this.coordinate = coordinate;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsle() {
		return isle;
	}

	public void setIsle(String isle) {
		this.isle = isle;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int star) {
		this.stars = star;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", price=" + price + ", isle=" + isle + ", star=" + stars
				+ ", adress=" + adress + "]\n";
	}

}
