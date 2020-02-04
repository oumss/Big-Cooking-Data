package business;

import java.util.ArrayList;

public class Excursion {

	private ArrayList<Trip> trips = new ArrayList<Trip>();
	private double price;

	public Excursion() {

	}

	public Excursion(ArrayList<Trip> trips) {
		this.trips = trips;
		this.price = calculExcursionPrice(trips);
	}

	public double calculExcursionPrice(ArrayList<Trip> trips) {
		
		for (Trip trip : trips) { 
			price = price + trip.calculTripPrice(trip.getTransport(), trip.getDistance());
		}
		for (Trip trip : trips) {
			price = price + trip.getDeparturePoint().getPrice();
		}
		price = price - trips.get(0).getDeparturePoint().getPrice();

		return price;

	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean equals(Excursion excursion) {
		
		ArrayList<Trip> stock = null;
		
		for(Trip a : this.trips) {
			for(Trip b : excursion.trips) {
				if (a.equals(b)) {
					stock.add(a);
				}
			}
		}
		if(stock.get(3).equals(null)) {
			return false;
		}
		
		return true;
	}
}
