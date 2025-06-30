import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private Contact contact;
	private ContactService contactService;
	
	@BeforeEach
	void testContactServiceInitialize() {
		contact = new Contact("12345", "Brandon", "Hornick", "3041231234", "123 Central St");
		contactService = new ContactService();
	}
	
	// add contact name
	@Test
	void testContactServiceDuplicate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(contact);
			contactService.addContact(contact); // should fail since this has been added, and verifies the service adds correctly
		});
	}
	
	// Delete contact
	@Test
	void testContactServiceDeleteCorrect() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(contact);
			contactService.deleteContact(contact.getContactID()); 
			contactService.deleteContact(contact.getContactID()); // should fail since this has been deleted already
		});
	}
	@Test
	void testContactServiceDeleteNonexistent() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("fake"); // doesn't exist
		});
	}
	
	// Update First name
	void testContactServiceUpdateFirstName(){
		contactService.updateFirstName(contact, "check");
		assertTrue(contact.getFirstName().equals("check"));
	}
	void testContactServiceUpdateFirstNameTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName(contact, "checkkkkkkkkkkkkk");
		});
	}
	
	// Update Last name
	void testContactServiceUpdateLastName(){
		contactService.updateLastName(contact, "check");
		assertTrue(contact.getLastName().equals("check"));
	}
	void testContactServiceUpdateLastNameTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName(contact, "checkkkkkkkkkkkkk");
		});
	}
	
	// Update Phone
	void testContactServiceUpdatePhone(){
		contactService.updatePhone(contact, "3041231234");
		assertTrue(contact.getPhone().equals("3041231234"));
	}
	void testContactServiceUpdatePhoneTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhone(contact, "30412312345");
		});
	}
	
	// Update Address
	void testContactServiceUpdateAddress(){
		contactService.updateAddress(contact, "123 5 st");
		assertTrue(contact.getAddress().equals("123 5 st"));
	}
	void testContactServiceUpdateAddressTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress(contact, "123 too long of a street name st");
		});
	}
}
	