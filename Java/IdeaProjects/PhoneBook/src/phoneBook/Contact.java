
package phoneBook;


public class Contact
{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailContact;
    private String address;


    Contact(String firstName, String lastName, String phoneNumber, String emailContact, String address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailContact = emailContact;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }
}
