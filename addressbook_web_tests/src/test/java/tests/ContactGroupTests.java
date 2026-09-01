package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactGroupTests extends TestBase {

    @Test
    void canAddContactToGroup() {
        var groups = app.hbm().getGroupList();
        var contacts = app.hbm().getContactList();

        // Предусловие: должна существовать группа
        if (groups.isEmpty()) {
            app.hbm().createGroup(
                    new GroupData().withName("test group").withHeader("test header").withFooter("test footer")
            );
            groups = app.hbm().getGroupList();
        }
        // Предусловие: должен существовать контакт
        if (contacts.isEmpty()) {
            app.contacts().createContact(
                    new ContactData().withFirstName("Ivan").withLastName("Ivanov")
            );
            contacts = app.hbm().getContactList();
        }
        var group = groups.get(0);
        var contactsInGroup = app.hbm().getContactsInGroup(group);
        // Ищем контакт, которого ещё нет в выбранной группе
        var contact = contacts.stream().filter(c -> !contactsInGroup.contains(c)).findFirst();
        // Если все существующие контакты уже в группе — создаём новый
        if (contact.isEmpty()) {
            app.contacts().createContact(
                    new ContactData().withFirstName("Ivan1").withLastName("Ivanov1")
            );
            contacts = app.hbm().getContactList();
            app.groups().openGroupsPage();
            app.contacts().openHomePage();
            contact = contacts.stream()
                    .filter(c -> !contactsInGroup.contains(c))
                    .findFirst();
        }
        var contactToAdd = contact.orElseThrow();
        app.contacts().addContactToGroup(contactToAdd, group);
        var newContactsInGroup = app.hbm().getContactsInGroup(group);
        Assertions.assertTrue(newContactsInGroup.contains(contactToAdd));
    }

    @Test
    void canRemoveContactFromGroup() {
        var groups = app.hbm().getGroupList();
        var contacts = app.hbm().getContactList();

        if (groups.isEmpty()) {
            app.hbm().createGroup(new GroupData().withName("test group"));
            groups = app.hbm().getGroupList();
            app.groups().openGroupsPage();
            app.contacts().openHomePage();
        }
        if (contacts.isEmpty()) {
            app.contacts().createContact(
                    new ContactData().withFirstName("Ivan").withLastName("Ivanov")
            );
            contacts = app.hbm().getContactList();
        }
        var group = groups.get(0);
        var contactsInGroup = app.hbm().getContactsInGroup(group);
        var contact = contacts.get(0);

        if (!contactsInGroup.contains(contact)) {
            app.contacts().addContactToGroup(contact, group);
        }
        app.contacts().removeContactFromGroup(contact, group);
        var newContactsInGroup = app.hbm().getContactsInGroup(group);
        Assertions.assertFalse(newContactsInGroup.contains(contact));
    }
}
