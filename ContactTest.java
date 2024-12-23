import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "123456789", "123 Main St");
        });
    }

    @Test
    public void testUpdatableFields() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setPhone("0987654321");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("0987654321", contact.getPhone());
    }
}
