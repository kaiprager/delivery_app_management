package delivery_app_management_system;

public class Delivery {
	
	private static int nextID = 1;
	
	private int id;
	private String itemName;
	private double itemWeight;
	private Customer customer;
	private boolean delivered;
	
	public Delivery(String itemName, double itemWeight, Customer customer) {
		super();
		this.id = nextID++;
		this.itemName = itemName;
		this.itemWeight = itemWeight;
		this.customer = customer;
		this.delivered = false;
	}

	
	public int getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemWeight() {
		return itemWeight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public boolean isDelivered() {
		return delivered;
	}
	
	
	public void markDelivered() {
		this.delivered = true;
	}

}
