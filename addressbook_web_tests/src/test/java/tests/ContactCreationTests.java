package tests;

import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateNewContact() {
        app.openHomePage();
        app.createContact();
    }

    @Test
    public void canCreateNewEmptyContact() {
        app.openHomePage();
        app.createEmptyContact();
    }


}

