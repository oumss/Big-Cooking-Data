package business;

public interface Transport {


	public float getPrice_transport();

	public void setPrice_transport(float price_transport);

	public int getId_transport();

	public void setId_transport(int id_transport);
	
	public boolean equals(Transport transport);

}
