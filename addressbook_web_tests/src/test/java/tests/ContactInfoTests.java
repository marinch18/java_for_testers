package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testContactInfo() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withFirstName("Ivan")
                    .withLastName("Ivanov")
                    .withAddress("Moscow")
                    .withHome("123456")
                    .withMobile("987654")
                    .withWork("555555")
                    .withEmail("ivan@test.ru")
                    .withEmail2("ivan2@test.ru")
                    .withEmail3("ivan3@test.ru"));
        }
        var contact = app.hbm().getContactList().get(0);
        var phones = app.contacts().getPhones(contact);
        var address = app.contacts().getAddress(contact);
        var emails = app.contacts().getEmails(contact);

        var contactFromEditForm = app.contacts().getContactFromEditForm(contact);

        var expectedPhones = Stream.of(
                        contactFromEditForm.home(),
                        contactFromEditForm.mobile(),
                        contactFromEditForm.work()
                )
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining("\n"));

        var expectedEmails = Stream.of(
                        contactFromEditForm.email(),
                        contactFromEditForm.email2(),
                        contactFromEditForm.email3()
                )
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining("\n"));

        Assertions.assertEquals(expectedPhones, phones);
        Assertions.assertEquals(contactFromEditForm.address(), address);
        Assertions.assertEquals(expectedEmails, emails);
        }
}
