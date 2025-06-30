/* 
The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
*/

public class Contact{
	
	//// Contact Objects
	private final String contactID; // final so it is unchangeable
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address){
		
		/* CONTACT ID */
		// check for length and null without setter since ID can't be changed
		if(contactID == null || contactID.length() > 10 ) {
			throw new IllegalArgumentException("Contact ID must be 10 or less characters!");
		}
		this.contactID = contactID;
		
		
		// Use setters to check and set fields, changed from original submission
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	//SETTERS AND GETTERS
	// Contact ID 
	public String getContactID() {
		return this.contactID;
	}
	
	// First Name
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name must be 10 or less characters!");
		}
		this.firstName = firstName;
	}
	
	// Last Name
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name must be 10 or less characters");
		}
		this.lastName = lastName;
	}
	
	// Phone
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone must be 10 characters exactly!");
		}
		this.phone = phone;
	}
	
	// Address
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address must be 30 or less characters!");
		}
		this.address = address;
	}
	

	
	
}