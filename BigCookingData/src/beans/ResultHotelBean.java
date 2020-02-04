package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.Hotel;

@ManagedBean
@SessionScoped
public class ResultHotelBean implements Serializable {

	private static final long serialVersionUID = 6955508471291131930L;

	@ManagedProperty(value = "#{searchHotelBean}")
	private SearchHotelBean searchHotelBean;

	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public ResultHotelBean() {
	}

	@PostConstruct
	public void init() {
		hotels.addAll(searchHotelBean.getHotels());
	}

	public SearchHotelBean getSearchHotelBean() {
		return searchHotelBean;
	}

	public void setSearchHotelBean(SearchHotelBean searchHotelBean) {
		this.searchHotelBean = searchHotelBean;
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}

}
