package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
//        for (var firstName : List.of("", "firstName")) {
//            for (var middleName : List.of("", "middleName")) {
//                for (var lastName : List.of("", "lastName")) {
//                    for (var address : List.of("", "address")) {
//                        for (var home : List.of("", "home")) {
//                            result.add(new ContactData()
//                                            .withFirstName(firstName)
//                                            .withMiddleName(middleName)
//                                            .withLastName(lastName)
//                                            .withAddress(address)
//                                            .withHome(home)
//                                            .withPhoto("src/test/resources/images/avatar.png")
//                                            .withMobile("mobile")
//                                            .withWork("work")
//                                            .withEmail("email@test.ru")
//                                            .withEmail2("email2@test.ru")
//                                            .withEmail3("email3@test.ru"));
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            result.add(new ContactData()
//                    .withFirstName(CommonFunctions.randomString(i * 10))
//                    .withMiddleName(CommonFunctions.randomString(i * 10))
//                    .withLastName(CommonFunctions.randomString(i * 10))
//                    .withPhoto("src/test/resources/images/avatar.png")
//                    .withAddress(CommonFunctions.randomString(i * 10))
//                    .withHome(CommonFunctions.randomString(i * 10))
//                    .withMobile(CommonFunctions.randomString(i * 10))
//                    .withWork(CommonFunctions.randomString(i * 10))
//                    .withEmail(CommonFunctions.randomString(i * 10))
//                    .withEmail2(CommonFunctions.randomString(i * 10))
//                    .withEmail3(CommonFunctions.randomString(i * 10)));
//        }
        var mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<ContactData>();
        for (var oldContact : oldContacts) {
            expectedList.add(new ContactData()
                    .withFirstName(oldContact.firstName())
                    .withLastName(oldContact.lastName()));
        }
        expectedList.add(new ContactData()
                .withFirstName(contact.firstName())
                .withLastName(contact.lastName()));

        var actualList = new ArrayList<ContactData>();

        for (var newContact : newContacts) {
            actualList.add(new ContactData()
                    .withFirstName(newContact.firstName())
                    .withLastName(newContact.lastName()));
        }
        Comparator<ContactData> compareByName = Comparator
                .comparing(ContactData::lastName)
                .thenComparing(ContactData::firstName);

        actualList.sort(compareByName);
        expectedList.sort(compareByName);

        Assertions.assertEquals(actualList, expectedList);
    }

    @Test
    void canCreatteContact() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }

    @Test
    void canCreatteContactInGroup() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()+1, newRelated.size());
    }

}

