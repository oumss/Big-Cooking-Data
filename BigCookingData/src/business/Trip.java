package business;

public class Trip {

	private Place departurePoint;
	private Place arrivalPoint;
	private Transport transport;
	private double tripPrice;
	private double distance;

	public Trip() {
	}

	public Trip(Place departurePoint, Place arrivalPoint, Transport transport) {
		this.departurePoint = (Place) departurePoint;
		this.arrivalPoint = (Place) arrivalPoint;
		this.transport = transport;
		this.distance = Distance.calculDistance(departurePoint.getCoordinate().getLatitude(), departurePoint.getCoordinate().getLongitude(), arrivalPoint.getCoordinate().getLatitude(), arrivalPoint.getCoordinate().getLongitude(), "K");
		this.tripPrice = calculTripPrice(transport,distance);
	}

	public double calculTripPrice(Transport transport, double distance) {
		double transportPrice = transport.getPrice_transport();
		double tripPrice = transportPrice * distance;
		return tripPrice;
	}

	public Place getDeparturePoint() {
		return departurePoint;
	}

	public void setDeparturePoint(Place departurePoint) {
		this.departurePoint = departurePoint;
	}

	public Place getArrivalPoint() {
		return arrivalPoint;
	}

	public void setArrivalPoint(Place arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public double getTripPrice() {
		return this.tripPrice;
	}

	public void setTripPrice(double tripPrice) {
		this.tripPrice = tripPrice;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public boolean equals(Trip trip) {
		if ((this.departurePoint.equals(trip.departurePoint)) && (this.arrivalPoint.equals(trip.getArrivalPoint())) && this.transport.equals(trip.getTransport())){
			return true;
		}
		
		return true;
	}

}
