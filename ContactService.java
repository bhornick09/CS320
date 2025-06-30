import java.util.HashMap;
import java.util.Scanner;
/*
The contact service shall be able to add contacts with a unique ID.
The contact service shall be able to delete contacts per contact ID.
The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
firstName
lastName
Number
Address
*/

public class ContactService{
	private HashMap<String, Contact> contactMap = new HashMap<>();

	// Add Contact
	public void addContact(Contact contact) {
		// Check for existing contact ID
		if(contactMap.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID not unique"); // exit and do not add contact
		}
		// if contact ID does not exist, create contact
		contactMap.put(contact.getContactID(), contact);
	}
	
	// Delete contact per contactID
	public void deleteContact(String contactID) {
		if(contactMap.containsKey(contactID)) {
			contactMap.remove(contactID); // delete contact
		}
		else {
			throw new IllegalArgumentException("Contact ID does not exist!");
		}
	}
	
	// Update contact per contactID
	public void updateContact(String contactID) {
		// Check if contact ID exists
		if(contactMap.containsKey(contactID)) {
			
			//display options
			System.out.println("What would you like to modify?");
			System.out.println("1. First Name");
			System.out.println("2. Last Name");
			System.out.println("3. Phone");
			System.out.println("4. Address");
			// Get user input
			Scanner input = new Scanner(System.in);
			String selection = input.next();
			Contact modifyContact = contactMap.get(contactID);
			
			// Process selection with switch checking each valid choice
			switch(selection) {
				case "1":
					System.out.println("Enter the new first name: ");
					selection = input.next();
					updateFirstName(modifyContact, selection);
					break;
				case "2":
					System.out.println("Enter the new last name: ");
					selection = input.next();
					updateLastName(modifyContact, selection);
					break;
				case "3":
					System.out.println("Enter the new phone number: ");
					selection = input.next();
					updatePhone(modifyContact, selection);
					break;
				case "4":
					System.out.println("Enter the new address: ");
					selection = input.next();
					updateAddress(modifyContact, selection);
					break;
				default:
					System.out.println("Invalid seletion!");
			}
		}
	}
	
	// update functions 
	public void updateFirstName(Contact contact, String name) {
		contact.setFirstName(name);
	}
	public void updateLastName(Contact contact, String lastName) {
		contact.setLastName(lastName);
	}
	public void updatePhone(Contact contact, String phone) {
		contact.setPhone(phone);
	}
	public void updateAddress(Contact contact, String address) {
		contact.setAddress(address);
	}
}