package delivery_app_management_system;

public class Customer {
	
	private static int nextID = 1;
	
	private int id;
	private String name;
	private String address;
	
	public Customer(String name, String address) {
		this.id = nextID++;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	

}
