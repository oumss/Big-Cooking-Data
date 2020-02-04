package business;

public class Boat implements Transport {

	private int id_transport;
	private float price_transport;

	public Boat() {
	}

	public Boat(int id_transport, int price_transport) {
		this.id_transport = id_transport;
		this.price_transport = price_transport;
	}



	@Override
	public float getPrice_transport() {
		return price_transport;
	}

	@Override
	public void setPrice_transport(float price_transport) {
		this.price_transport = price_transport;
	}

	@Override
	public int getId_transport() {
		return id_transport;
	}

	@Override
	public void setId_transport(int id_transport) {
		this.id_transport = id_transport;
	}
	
	
	public boolean equals(Transport boat) {
		
		if (this.getId_transport() == boat.getId_transport()){
			return true;
		}
		
		return false;
		
	}


}
