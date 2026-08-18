package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov"));
        }
        var oldContacts = app.contacts().getList();

        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());

        var testData = new ContactData()
                .withFirstName("modified first name")
                .withLastName("modified last name");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<ContactData>();
        for (int i = 0; i < oldContacts.size(); i++) {
            if (i == index) {
                expectedList.add(new ContactData()
                        .withFirstName(testData.firstName())
                        .withLastName(testData.lastName()));
            } else {
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
        Comparator<ContactData> compareByName = Comparator.comparing(ContactData::lastName).thenComparing(ContactData::firstName);
        actualList.sort(compareByName);
        expectedList.sort(compareByName);
        Assertions.assertEquals(actualList, expectedList);
    }

}
