package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void сanModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstName("Ivan").withAddress("Moskow"));
        }
        app.contacts().modifyContact(new ContactData().withFirstName("modified first name"));
    }

}
