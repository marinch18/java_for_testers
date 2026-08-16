package manager;

import model.ContactData;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openHomePage();
        newContactPage();
        fillContactForm(contact);
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
        returnToHomePage();
    }

    public void modifyContact(ContactData modifiedContact) {
        openHomePage();
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContacts();
    }

    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
    }


    public void openHomePage() {
        if (!manager.isElementPresent(By.name("selected[]"))) {
            returnToHomePage();
        }
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void selectContact(ContactData contact) {
        click(By.xpath(String.format(
                "//tr[@name='entry'][td[2][normalize-space()='%s']][td[3][normalize-space()='%s']]//input[@name='selected[]']",
                contact.lastName(),
                contact.firstName())));
    }

    private void selectAllContacts() {
        click(By.id("MassCB"));
    }


    private void removeSelectedContacts() {
        click(By.name("delete"));
        //manager.driver.switchTo().alert().accept();
        // В текущей версии AddressBook alert отсутствует.
    }

    private void initContactModification() {
        click(By.xpath("//img[@title='Edit']"));
    }

    private void newContactPage() {
        click(By.linkText("add new"));
    }

    public List<ContactData> getList() {
        openHomePage();

        var contacts = new ArrayList<ContactData>();
        var rows = manager.driver.findElements(By.cssSelector("tr[name='entry']"));

        for (var row : rows) {
            var cells = row.findElements(By.tagName("td"));

            var lastName = cells.get(1).getText();
            var firstName = cells.get(2).getText();

            contacts.add(new ContactData()
                    .withFirstName(firstName)
                    .withLastName(lastName));
        }

        return contacts;
    }
}

