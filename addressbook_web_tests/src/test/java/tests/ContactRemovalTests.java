package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactRemovalTests extends TestBase {

    @Test
    public void canContactRemove() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData().withFirstName("Ivan").withAddress("Moskow"));
        }
        app.contact().removeContact();
    }
}