package delivery_app_management_system;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
	
	private List<Customer> customers;
	private List<Delivery> deliveries;
	
	public DeliveryService() {
		customers = new ArrayList<>();
		deliveries = new ArrayList<>();
	}
	
	public void registerCustomers(String name, String address) {
		Customer customer = new Customer(name, address);
		customers.add(customer);
		System.out.println(customer.getName() + " registered with ID: " + customer.getId());
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void placeDelivery(String itemName, double itemWeight, int customerID) {
		Customer customer = getCustomerByID(customerID);
		if(customer != null) {
			Delivery delivery = new Delivery(itemName, itemWeight, customer);
			deliveries.add(delivery);
			System.out.println("Order of " + delivery.getItemName() + " placed with ID: " + delivery.getId());
		} else {
			System.err.println("Customer not found. Unable to place order.");
		}
	}
	
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	
	public void markDeliveryAsDelivered(int deliveryID) {
		for(Delivery delivery : deliveries) {
			if(delivery.getId() == deliveryID) {
				delivery.markDelivered();
				System.out.println("Item was delivered.");
				return;
			}
		}
		
		System.err.println("Delivery not found.");
	}
	
	private Customer getCustomerByID(int customerID) {
		for(Customer customer : customers) {
			if(customer.getId() == customerID) {
				return customer;
			}
		}
		return null;
	}

}
