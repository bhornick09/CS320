import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	// make variables accessible
	private Contact contact;
	private String id = "12345";
	private String firstName = "Brandon";
	private String lastName = "Hornick";
	private String phone = "3041231234";
	private String address = "123 Central St";
	
	@BeforeEach
	void testContactClass() {
		contact = new Contact(id, firstName, lastName, phone, address);		
	}
	
	// get contact id, names, phone, and address
	@Test
	void testContactClassGetContactID() {
		assertTrue(contact.getContactID().equals(id));
	}
	@Test
	void testContactClassGetFirstName() {
		assertTrue(contact.getFirstName().equals(firstName));
	}
	@Test
	void testContactClassGetLastName() {
		assertTrue(contact.getLastName().equals(lastName));
	}
	@Test
	void testContactClassGetPhone() {
		assertTrue(contact.getPhone().equals(phone));
	}
	@Test
	void testContactClassGetAddress() {
		assertTrue(contact.getAddress().equals(address));
	}
	// CONTACT ID
	// The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Brandon", "Hornick", "3041231234", "123 Central St");
		});
	}
	// The contact ID shall not be null.
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Brandon", "Hornick", "3041231234", "123 Central St");
		});
	}
	
	// FIRST NAME
	// The contact object shall have a required firstName String field that cannot be longer than 10 characters.
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon123456789", "Hornick", "3041231234", "123 Central St");
		});
	}
	// The firstName field shall not be null.
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Hornick", "3041231234", "123 Central St");
		});
	}
	
	// LAST NAME
	// The contact object shall have a required lastName String field that cannot be longer than 10 characters.
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", "Hornick123456789", "3041231234", "123 Central St");
		});
	}
	// The lastName field shall not be null.
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", null, "3041231234", "123 Central St");
		});
	}
	
	// PHONE
	// The contact object shall have a required phone String field that must be exactly 10 digits.
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", "Hornick", "3", "123 Central St");
		});
	}
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", "Hornick", "30412312345", "123 Central St");
		});
	}
	// The phone field shall not be null.
	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", "Hornick", null, "123 Central St");
		});
	}
	
	// ADDRESS
	// The contact object shall have a required address field that must be no longer than 30 characters.
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", "Hornick", "3041231234", "1234567890123456789012345678901");
		});
	}
	// The address field shall not be null.
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Brandon", "Hornick", "3041231234", null);
		});
	}
}