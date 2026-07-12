package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void сanModifyContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData().withFirstName("Ivan").withAddress("Moskow"));
        }
        app.contact().modifyContact(new ContactData().withFirstName("modified first name"));
    }
}
