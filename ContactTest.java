//Author Name: Gage Sovey

//Date: 9/22/2024

//Course ID: CS-320, Prof. Cross

//Description: This is the unit tests for the contact class (ContactTest).

package module3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {

	private Contact contact;

    @BeforeEach
    void setUp() {
        // Initialize a new Contact object before each test
        contact = new Contact("John", "Doe", "1234567890", "123 Main Street");
    }
    
    @Test
    void testContactIDNotNullAndUnique() {
        // Create two contact objects
        Contact contact1 = new Contact("John", "Doe", "1234567890", "123 Main Street");
        Contact contact2 = new Contact("Jane", "Smith", "0987654321", "456 Elm Street");

        // Ensure the contact ID is not null
        assertNotNull(contact1.getContactID(), "Contact ID for contact1 is null.");
        assertNotNull(contact2.getContactID(), "Contact ID for contact2 is null.");

        // Ensure the contact IDs are unique
        assertNotEquals(contact1.getContactID(), contact2.getContactID(), "Contact IDs are not unique.");
    }

    @Test
    void testFirstNameNotNullAndTruncated() {
        // Test null first name
        Contact contact = new Contact(null, "Doe", "1234567890", "123 Main Street");
        assertTrue(contact.getFirstName().contains("NULL"), "First name was not set to 'NULL' when null.");

        // Test first name longer than 10 characters
        contact = new Contact("LongerThanTenChars", "Doe", "1234567890", "123 Main Street");
        assertTrue(contact.getFirstName().contains("LongerThan"), "First name was not truncated to 10 characters.");
    }

    @Test
    void testLastNameNotNullAndTruncated() {
        // Test null last name
        Contact contact = new Contact("John", null, "1234567890", "123 Main Street");
        assertTrue(contact.getLastName().contains("NULL"), "Last name was not set to 'NULL' when null.");

        // Test last name longer than 10 characters
        contact = new Contact("John", "LongerThanTenChars", "1234567890", "123 Main Street");
        assertTrue(contact.getLastName().contains("LongerThan"), "Last name was not truncated to 10 characters.");
    }

    @Test
    void testPhoneNumberValidation() {
        // Test valid phone number
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main Street");
        assertTrue(contact.getNumber().contains("1234567890"), "Phone number was not set correctly.");

        // Test invalid phone numbers
        contact = new Contact("John", "Doe", "12345", "123 Main Street");
        assertTrue(contact.getNumber().contains("5555555555"), "Invalid phone number did not default to '5555555555'.");

        contact = new Contact("John", "Doe", null, "123 Main Street");
        assertTrue(contact.getNumber().contains("5555555555"), "Null phone number did not default to '5555555555'.");
    }

    @Test
    void testAddressNotNullAndTruncated() {
        // Test null address
        contact = new Contact("John", "Doe", "1234567890", null);
        assertEquals("NULL", contact.getAddress(), "Address was not set to 'NULL' when null.");

        // Test address longer than 30 characters
        contact = new Contact("John", "Doe", "1234567890", "This address is way too long and should be truncated.");
        
        // Expected truncated address (30 characters)
        String expectedAddress = "This address is way too long a";
        
        // Check if the address matches the expected truncation
        assertEquals(expectedAddress, contact.getAddress(), "Address was not truncated to 30 characters.");
    }




    @Test
    void testSettersFunctionCorrectly() {
        // Test first name setter
        contact.setFirstName("NewFirstNameLongerThanTen");
        assertEquals("NewFirstNa", contact.getFirstName(), "First name setter did not truncate correctly.");

        // First name set to null
        contact.setFirstName(null);
        assertEquals("NULL", contact.getFirstName(), "First name setter did not handle null correctly.");

        // Test last name setter
        contact.setLastName("NewLastNameLongerThanTen");
        assertEquals("NewLastNam", contact.getLastName(), "Last name setter did not truncate correctly.");

        // Last name set to null
        contact.setLastName(null);
        assertEquals("NULL", contact.getLastName(), "Last name setter did not handle null correctly.");

        // Test phone number setter
        contact.setNumber("9876543210"); // Valid 10-digit number
        assertEquals("9876543210", contact.getNumber(), "Phone number setter did not set correctly.");

        contact.setNumber("123"); // Invalid phone number (less than 10 digits)
        assertEquals("5555555555", contact.getNumber(), "Phone number setter did not handle invalid number correctly.");

        // Test address setter with a string longer than 30 characters
        contact.setAddress("This address is way too long and should be truncated.");
        assertEquals("This address is way too long a", contact.getAddress(), "Address setter did not truncate correctly.");

        // Address set to null
        contact.setAddress(null);
        assertEquals("NULL", contact.getAddress(), "Address setter did not handle null correctly.");
    }


}



