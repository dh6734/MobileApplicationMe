package contactmobileApplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("1", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactID_Null() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactID_TooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName_Null() {
        new Contact("1", null, "Doe", "1234567890", "123 Main St");
    }

    // Additional test cases for other fields (lastName, phone, address) should follow similar patterns

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Alice");

        assertEquals("Alice", contact.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstName_Null() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName(null);
    }

    // Additional test cases for setLastName, setPhone, setAddress should be added similarly
}
