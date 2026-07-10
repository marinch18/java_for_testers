package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactRemovalTests extends TestBase {

    @Test
    public void canContactRemove() {
        if (!app.isContactPresent()) {
            app.createContact(new ContactData().withFirstName("Ivan").withAddress("Moskow"));
        }
        app.removeContact();
    }
}