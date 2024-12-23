import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteNonExistingContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("non-existing-id");
        });
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", "Jane", null, null, "456 Elm St");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testUpdateNonExistingContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("non-existing-id", "Jane", "Doe", "0987654321", "456 Elm St");
        });
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }
}
