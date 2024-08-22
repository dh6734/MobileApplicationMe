package contactmobileApplication;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () -> contactService.getContact("1"));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateFirstName("1", "Jane");
        assertEquals("Jane", contactService.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateLastName("1", "Smith");
        assertEquals("Smith", contactService.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updatePhone("1", "0987654321");
        assertEquals("0987654321", contactService.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateAddress("1", "456 Elm St");
        assertEquals("456 Elm St", contactService.getContact("1").getAddress());
    }
}
