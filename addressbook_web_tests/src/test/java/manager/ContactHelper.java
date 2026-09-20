package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openHomePage();
        newContactPage();
        fillContactForm(contact);
        click(By.xpath("(//input[@name='submit'])[2]"));
        returnToHomePage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openHomePage();
        newContactPage();
        fillContactForm(contact);
        selectGroup(group);
        click(By.xpath("(//input[@name='submit'])[2]"));
        returnToHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        initContactModification(contact);
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

    public void addContactToGroup(ContactData contact, GroupData group) {
        click(By.linkText("home"));

        var groupSelect = new Select(manager.driver.findElement(By.name("group")));
        groupSelect.selectByVisibleText("[all]");

        selectContact(contact);

        new Select(manager.driver.findElement(By.name("to_group")))
                .selectByValue(group.id());

        click(By.name("add"));
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        new Select(manager.driver.findElement(By.name("group")))
                .selectByValue(group.id());
        selectContact(contact);
        click(By.name("remove"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        attach(By.name("photo"), contact.photo());
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
                "//input[@name='selected[]' and @value='%s']",
                contact.id())));
    }

    private void selectAllContacts() {
        click(By.id("MassCB"));
    }


    private void removeSelectedContacts() {
        click(By.name("delete"));
        //manager.driver.switchTo().alert().accept();
        // В текущей версии AddressBook alert отсутствует.
    }

    private void initContactModification(ContactData contact) {
        click(By.xpath(String.format(
                "//input[@name='selected[]' and @value='%s']/ancestor::tr//img[@title='Edit']", contact.id())));
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
            var id = cells.get(0).findElement(By.name("selected[]")).getAttribute("value");

            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastName));
        }

        return contacts;
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();

    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }
}

