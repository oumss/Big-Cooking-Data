package business;

public class Coordinate {

	private int id;
	private double longitude;
	private double latitude;

	public Coordinate() {
	}

	public Coordinate(int id, double Longitude, double Latitude) {

		this.id = id;
		this.longitude = Longitude;
		this.latitude = Latitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double Longitude) {
		this.longitude = Longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double Latitude) {
		this.latitude = Latitude;
	}

}
