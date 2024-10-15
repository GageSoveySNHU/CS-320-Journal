//Author Name: Gage Sovey

//Date: 9/22/2024

//Course ID: CS-320, Prof. Cross

//Description: This is the unit tests for the contactService  class (ContactServiceTest).

package module3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ContactServiceTest {

    private ContactService contactService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        System.setOut(new PrintStream(outputStreamCaptor));  // Redirect System.out to capture output
    }
    
    @Test
    void testDisplayContactList() {
        // Add two contacts to the service
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        contactService.addContact("Jane", "Smith", "0987654321", "456 Elm Street");

        // Call the method to display the contact list
        contactService.displayContactList();

        // Capture the actual output
        String actualOutput = outputStreamCaptor.toString().trim();

        // Use contains() to check that the key parts of the output are correct
        assertTrue(actualOutput.contains("Contact ID: " + contactService.contactList.get(0).getContactID()), "First contact ID not found.");
        assertTrue(actualOutput.contains("First Name: John"), "First contact first name not found.");
        assertTrue(actualOutput.contains("Last Name: Doe"), "First contact last name not found.");
        assertTrue(actualOutput.contains("Phone Number: 1234567890"), "First contact phone number not found.");
        assertTrue(actualOutput.contains("Address: 123 Main Street"), "First contact address not found.");

        assertTrue(actualOutput.contains("Contact ID: " + contactService.contactList.get(1).getContactID()), "Second contact ID not found.");
        assertTrue(actualOutput.contains("First Name: Jane"), "Second contact first name not found.");
        assertTrue(actualOutput.contains("Last Name: Smith"), "Second contact last name not found.");
        assertTrue(actualOutput.contains("Phone Number: 0987654321"), "Second contact phone number not found.");
        assertTrue(actualOutput.contains("Address: 456 Elm Street"), "Second contact address not found.");
    }



    @Test
    void testAddContactWithUniqueID() {
        // Add two contacts to the service
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        contactService.addContact("Jane", "Smith", "0987654321", "456 Elm Street");

        // Ensure that two contacts were added
        assertEquals(2, contactService.contactList.size(), "Contact list should have 2 contacts.");

        // Ensure that contact IDs are unique
        Contact contact1 = contactService.contactList.get(0);
        Contact contact2 = contactService.contactList.get(1);
        assertNotNull(contact1.getContactID(), "Contact 1 ID is null.");
        assertNotNull(contact2.getContactID(), "Contact 2 ID is null.");
        assertNotEquals(contact1.getContactID(), contact2.getContactID(), "Contact IDs should be unique.");
    }

    @Test
    void testDeleteContactByID() {
        // Add a contact
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        String contactID = contactService.contactList.get(0).getContactID();

        // Delete the contact
        contactService.deleteContact(contactID);

        // Ensure the contact was deleted
        assertEquals(0, contactService.contactList.size(), "Contact list should be empty after deletion.");
    }

    @Test
    void testUpdateFirstNameByID() {
        // Add a contact
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        String contactID = contactService.contactList.get(0).getContactID();

        // Update the first name
        contactService.updateFirstName("Jonathan", contactID);

        // Verify the first name was updated
        assertEquals("Jonathan", contactService.contactList.get(0).getFirstName(), "First name was not updated.");
    }

    @Test
    void testUpdateLastNameByID() {
        // Add a contact
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        String contactID = contactService.contactList.get(0).getContactID();

        // Update the last name
        contactService.updateLastName("Smith", contactID);

        // Verify the last name was updated
        assertEquals("Smith", contactService.contactList.get(0).getLastName(), "Last name was not updated.");
    }

    @Test
    void testUpdatePhoneNumberByID() {
        // Add a contact
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        String contactID = contactService.contactList.get(0).getContactID();

        // Update the phone number
        contactService.updateNumber("0987654321", contactID);

        // Verify the phone number was updated
        assertEquals("0987654321", contactService.contactList.get(0).getNumber(), "Phone number was not updated.");
    }

    @Test
    void testUpdateAddressByID() {
        // Add a contact
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");
        String contactID = contactService.contactList.get(0).getContactID();

        // Update the address
        contactService.updateAddress("789 Oak Street", contactID);

        // Verify the address was updated
        assertEquals("789 Oak Street", contactService.contactList.get(0).getAddress(), "Address was not updated.");
    }

    @Test
    void testDeleteNonExistentContact() {
        // Try to delete a contact that doesn't exist
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");

        // Deleting a non-existent contact (no exception should occur)
        contactService.deleteContact("nonExistentID");

        // Verify the original contact is still there
        assertEquals(1, contactService.contactList.size(), "Contact list size should remain 1 after attempting to delete a non-existent contact.");
    }

    @Test
    void testUpdateNonExistentContact() {
        // Add a contact
        contactService.addContact("John", "Doe", "1234567890", "123 Main Street");

        // Try to update a non-existent contact (no exception should occur)
        contactService.updateFirstName("NonExistentFirstName", "nonExistentID");

        // Verify the original contact's first name was not changed
        assertEquals("John", contactService.contactList.get(0).getFirstName(), "First name should not have been updated for a non-existent contact.");
    }
}
