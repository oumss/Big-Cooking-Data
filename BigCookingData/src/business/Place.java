package business;

public class Place {

	private Coordinate coordinate;
	private int price;
	private boolean boatDisponibility;
	private boolean busDisponibility;

	public Place() {

	}

	public Place(Coordinate coordinate, int price, boolean boatDisponibility, boolean busDisponibility) {
		this.boatDisponibility = boatDisponibility;
		this.busDisponibility = busDisponibility;
		this.coordinate = coordinate;
		this.price = price;
	}

	public boolean isBoatDisponible() {
		return boatDisponibility;
	}

	public void setBoatDisponibility(boolean boatDisponibility) {
		this.boatDisponibility = boatDisponibility;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public boolean isBusDisponible() {
		return busDisponibility;
	}

	public void setBusDisponibility(boolean busDisponibility) {
		this.busDisponibility = busDisponibility;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean equals(Place place) {
		
		if (this.getClass().getName().equals("Site")) {
			if (place.getClass().getName().equals("Site")) {
			 
			Site site = (Site) this;
			Site site2 = (Site) place;
			
				if(site.getId()==site2.getId()) {
					return true;
				}
				
			}
		}
		
		if (this.getClass().getName().equals("Hotel")) {
			if (place.getClass().getName().equals("Hotel")) {
			 
			Hotel hotel = (Hotel) this;
			Hotel hotel2 = (Hotel) place;
			
				if(hotel.getId()==hotel2.getId()) {
					return true;
				}
				
			}
		}
		
		return false;
		
	}
	
}
