package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;


public class ContactRemovalTests extends TestBase {

    @Test
    public void canContactRemove() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<ContactData>();
        for (int i = 0; i < oldContacts.size(); i++) {
            if (i != index) {
                expectedList.add(new ContactData()
                        .withFirstName(oldContacts.get(i).firstName())
                        .withLastName(oldContacts.get(i).lastName()));
            }
        }
        var actualList = new ArrayList<ContactData>();

        for (var contact : newContacts) {
            actualList.add(new ContactData()
                    .withFirstName(contact.firstName())
                    .withLastName(contact.lastName()));
        }
        Assertions.assertEquals(actualList, expectedList);
    }

    @Test
    public void removeAllContacts() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCount());
    }

}