package delivery_app_management_system;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Delivery App\n".toUpperCase());
		System.out.println("\n");

		DeliveryService deliveryService = new DeliveryService();
		
		System.out.println("Registered Customers:".toUpperCase());
		deliveryService.registerCustomers("Bobby", "Cologne");
		deliveryService.registerCustomers("Sabine", "Berlin");
		deliveryService.registerCustomers("Hubertus", "Münster");
		deliveryService.registerCustomers("Betty", "Hanover");
		deliveryService.registerCustomers("Clive", "Munich");
		deliveryService.registerCustomers("Lance", "Frankfurt");
		
		System.out.println("\nPlaced Orders: ".toUpperCase());
		deliveryService.placeDelivery("Computer", 5.45, 1);
		deliveryService.placeDelivery("Cooker", 2.38, 2);
		deliveryService.placeDelivery("Book", 1.66, 3);
		deliveryService.placeDelivery("Teddy", 2.05, 4);
		deliveryService.placeDelivery("Picture", 3.52, 5);
		deliveryService.placeDelivery("Record", 2.99, 6);
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
            System.out.println("\n1. Display Customers");
            System.out.println("2. Display Deliveries");
            System.out.println("3. Mark Delivery as Delivered");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: \n");
            
            try {
            	int choice = scanner.nextInt();
            	scanner.nextLine();
            	
            	running = switch(choice) {
            		case 1 -> { 
            			displayCustomers(deliveryService.getCustomers());
            			yield true;
            		}
            		case 2 -> {
            			displayDeliveries(deliveryService.getDeliveries());
            			yield true;
            		}
            		case 3 -> {
            			System.out.println("Enter the delivery ID to mark item as delivered: ");
            			int deliveryID = scanner.nextInt();
            			deliveryService.markDeliveryAsDelivered(deliveryID);
            			yield true;
            		}
            		case 4 -> false;
            		default -> {
            			System.err.println("Invalid choice");
            			yield true;
            		}
            	};
            } catch(InputMismatchException e) {
            	System.err.println("Invalid input.");
            	scanner.nextLine();
            }
		}
		
		System.out.println("Exiting Delivery App.");
		
		scanner.close();
	}
	
	private static void displayCustomers(List<Customer> customers) {
		System.out.println("List of registered customers: ");
		for(Customer customer : customers) {
			System.out.println("ID: " + customer.getId() + "\t Name: " + customer.getName()
					+ "\t Address: " + customer.getAddress());
		}
	}
	
	private static void displayDeliveries(List<Delivery> deliveries) {
		System.out.println("List of deliveries: ");
		for(Delivery delivery : deliveries) {
			System.out.println("ID: " + delivery.getId() + "\t Item: " + delivery.getItemName() 
				+ "\t Weight: " + delivery.getItemWeight() + " kg\t " + "Customer : " 
				+ delivery.getCustomer().getName() + "\t Delivered: " 
				+ (delivery.isDelivered() ? "Yes" : "No"));
		}
	}

}
