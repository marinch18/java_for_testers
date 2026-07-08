package tests;

import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void CanCreateNewContact() {
        app.createContact();
    }

    @Test
    public void CanCreateNewEmptyContact() {
        app.createEmptyContact();
    }

}

