//Author Name: Gage Sovey

//Date: 9/22/2024

//Course ID: CS-320, Prof. Cross

//Description: This is the contact service. It maintains a list of contacts and has capabilities
//for adding and deleting contacts, as well as updating first name, last name, phone number, and address.

package module3;

import java.util.ArrayList;

public class ContactService {
//Start with an ArrayList of contacts to hold the list of contacts
ArrayList<Contact> contactList = new ArrayList<Contact>();

//Display the full list of contacts to the console for error checking.
public void displayContactList() {
for(int counter = 0; counter < contactList.size(); counter++) {
System.out.println("\t Contact ID: " + contactList.get(counter).getContactID());
System.out.println("\t First Name: " + contactList.get(counter).getFirstName());
System.out.println("\t Last Name: " + contactList.get(counter).getLastName());
System.out.println("\t Phone Number: " + contactList.get(counter).getNumber());
System.out.println("\t Address: " + contactList.get(counter).getAddress() + "\n");
}
}

//Adds a new contact using the Contact constructor, then assign the new contact to the list.
public void addContact(String firstName, String lastName, String number, String address) {
// Create the new contact
Contact contact = new Contact(firstName, lastName, number, address);
contactList.add(contact);
}

// Method for getting contact infomration based upon ID matching
public Contact getContact(String contactID) {
	Contact contact = new Contact("", "", "", "");
	
	for (int i = 0; i < contactList.size(); i++) {
		if (contactList.get(i).getContactID().contentEquals(contactID)) {
			contact = contactList.get(i);
		}
	}
	return contact;
}

// Method for deleting contact baed upon ID matching 
public void deleteContact(String contactID) {
	for (int i = 0; i < contactList.size(); i++) {
		if (contactList.get(i).getContactID().equals(contactID)) {
			contactList.remove(i);
		}
	}	
}


//Method for updating first name based upon ID matching 
public void updateFirstName(String updatedString, String contactID) {
	for (int i = 0; i < contactList.size(); i++) {
		if (contactList.get(i).getContactID().equals(contactID)) {
			contactList.get(i).setFirstName(updatedString);
		}
	}
}

//Method for updating last name based upon ID matching 
public void updateLastName(String updatedString, String contactID) {
	for (int i = 0; i < contactList.size(); i++) {
		if (contactList.get(i).getContactID().equals(contactID)) {
			contactList.get(i).setLastName(updatedString);
		}
	}
}

//Method for updating name based upon ID matching 
public void updateNumber(String updatedString, String contactID) {
	for (int i = 0; i < contactList.size(); i++) {
		if (contactList.get(i).getContactID().equals(contactID)) {
			contactList.get(i).setNumber(updatedString);
		}
	}
}

//Method for updating address based upon ID matching 
public void updateAddress(String updatedString, String contactID) {
	for (int counter = 0; counter < contactList.size(); counter++) {
		if (contactList.get(counter).getContactID().equals(contactID)) {
			contactList.get(counter).setAddress(updatedString);
			break;
		}
		if (counter == contactList.size() - 1) {
			System.out.println("Contact ID: " + contactID + " not found.");
		}
	}
}

}

