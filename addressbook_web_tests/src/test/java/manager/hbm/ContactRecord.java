package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import model.ContactData;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String address;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    static List<ContactData> convertContactList(List<ContactRecord> records) {
        List<ContactData> result = new ArrayList<>();

        for (var record : records) {
            result.add(convert(record));
        }

        return result;
    }

    private static ContactData convert(ContactRecord record) {
        return new ContactData()
                .withId("" + record.id)
                .withFirstName(record.firstname)
                .withLastName(record.lastname)
                .withAddress(record.address);
    }

    private static ContactRecord convert(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }

        return new ContactRecord(
                Integer.parseInt(id),
                data.firstName(),
                data.lastName(),
                data.address()
        );
    }
}