package book;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook {
	private ArrayList<Contact> contact = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public void start() {
		int choice;
		do {
			System.out.println("\n--- Contact Book Menu ---");
			System.out.println("1.Add Contact");
			System.out.println("2.View Contact");
			System.out.println("3.Search Contact");
			System.out.println("4.Delete Contact");
			System.out.println("5.Exit");

			System.out.print("Enter your choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				addContact();
			case 2:
				viewContact();
			case 3:
				searchContact();
			case 4:
				deleteContact();
			case 5:
				System.out.println("Exiting...");
			default:
				System.out.println("Invalid choice");

			}
		} while (choice != 5);
	}

	private void addContact() {
		System.out.println("Enter Name :");
		String name = sc.nextLine();
		System.out.println("Enter phone: ");
		String phone = sc.nextLine();
		System.out.println("Enter Email");
		String email = sc.nextLine();

		contact.add(new Contact(name, phone, email));

		System.out.println("Contact Added!");
	}

	private void viewContact() {
		if (contact.isEmpty()) {
			System.out.println("No contacts found");
		} else {
			contact.forEach(System.out::println);
		}
	}

	private void searchContact() {
		System.out.print("Enter name to search: ");
		String name = sc.nextLine();
		contact.stream().filter(c -> c.getName().equalsIgnoreCase(name)).forEach(System.out::println);
	}

	private void deleteContact() {
		System.out.print("Enter name to delete: ");
		String name = sc.nextLine();
		contact.removeIf(c -> c.getName().equalsIgnoreCase(name));
		System.out.println("Contact deleted if it existed.");
	}

}
