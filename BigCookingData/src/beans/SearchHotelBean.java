package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.Hotel;

@ManagedBean(name = "searchHotelBean", eager = true)
@SessionScoped
public class SearchHotelBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131930L;
	private String name;
	private String adress;
	private String price;
	private String isle;
	private String max;
	private String min;
	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public SearchHotelBean() {
	}

	@PostConstruct
	public void init() {
		name = "";
		adress = "";
		price = "";
		isle = "";
		max = "1000";
		min = "0";
	}

	public String searchHotel() {
		System.out.println(max + " " + min);
		String query;
		if (name == "") {
			query = "select * from hotel where hotel_price > " + min + " and hotel_price < " + max;

		} else {
			query = "select * from hotel where hotel_price > " + min + " and hotel_price < " + max + " and hotel_name='" + name + "'";

		}
		System.out.println("resultHotel query = "+query);
		//hotels.addAll(SearchHotel.operatorSQL(query));
		System.out.println("resultHotelBean hotels = "+hotels);
		return "resultHotel";
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsle() {
		return isle;
	}

	public void setIsle(String isle) {
		this.isle = isle;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}

}
