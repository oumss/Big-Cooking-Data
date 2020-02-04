package business;

public class Site extends Place {
	private int id;
	private String name;
	private String adress;
	private int price;
	private String type;
	private String isle;
	private Coordinate coordinate;

	public Site() {

	}

	public Site(int id, String name, String adress, int price, String type, String isle) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.price = price;
		this.type = type;
		this.isle = isle;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsle() {
		return isle;
	}

	public void setIsle(String isle) {
		this.isle = isle;
	}

	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", adress=" + adress + ", price=" + price + ", type=" + type
				+ ", isle=" + isle + "]\n";
	}
	

}
