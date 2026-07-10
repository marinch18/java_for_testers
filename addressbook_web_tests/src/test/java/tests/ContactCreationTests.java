package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateNewContact() {
        app.openHomePage();
        app.createContact(new ContactData("Ivan", "Ivanovich", "Ivanov",
                "Moskow street", "5", "+79998887766", "+74732333444", "email1@test.ru",
                "email2@test.ru", "email3@test.ru"));
    }

    @Test
    public void canCreateNewEmptyContact() {
        app.openHomePage();
        app.createContact(new ContactData());
    }

    @Test
    public void canCreateNewContactOnlyWithFirstName() {
        app.openHomePage();
        app.createContact(new ContactData().withFirstName("Ivan").withAddress("Moskow"));
    }


}

