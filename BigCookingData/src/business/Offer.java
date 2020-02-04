package business;

import java.util.ArrayList;

public class Offer {

	private double price;
	private Hotel hotel;
	private ArrayList<Excursion> excursions = new ArrayList<Excursion>();

	public Offer() {

	}

	public Offer(Hotel hotel, ArrayList<Excursion> excursions) {
		this.hotel = hotel;
		this.excursions = excursions;
		this.price = calculOffrePrice();
	}

	public double calculOffrePrice() {

		double offrePrice = 0;
		for (Excursion excursion : excursions) {
			offrePrice += excursion.calculExcursionPrice(excursion.getTrips());
		}

		return offrePrice;

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

}
