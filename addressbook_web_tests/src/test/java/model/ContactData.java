package model;

public record ContactData(String firstName,
                          String middleName,
                          String lastName,
                          String address,
                          String home,
                          String mobile,
                          String work,
                          String email,
                          String email2,
                          String email3) {


    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(firstName, this.middleName, this.lastName, this.address, this.home, this.mobile,
                this.work, this.email, this.email2, this.email3);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.firstName, middleName, this.lastName, this.address, this.home, this.mobile,
                this.work, this.email, this.email2, this.email3);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.firstName, this.middleName, lastName, this.address, this.home, this.mobile,
                this.work, this.email, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstName, this.middleName, this.lastName, address, this.home, this.mobile,
                this.work, this.email, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address, home, this.mobile,
                this.work, this.email, this.email2, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address, this.home, mobile,
                this.work, this.email, this.email2, this.email3);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address, this.home, this.mobile,
                work, this.email, this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address, this.home, this.mobile,
                this.work, email, this.email2, this.email3);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address, this.home, this.mobile,
                this.work, this.email, email2, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address, this.home, this.mobile,
                this.work, this.email, this.email2, email3);
    }
}
