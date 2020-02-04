package business;

public class Bus implements Transport {

	private int id_transport;
	private float price_transport;

	public Bus() {
	}

	public Bus(int price_transport) {
		this.id_transport = 0;
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

	public boolean equals(Transport bus) {
		
		if (this.getId_transport() == bus.getId_transport()){
			return true;
		}
		
		return false;
		
	}


}
