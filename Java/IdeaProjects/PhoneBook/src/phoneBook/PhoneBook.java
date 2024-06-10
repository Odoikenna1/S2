package phoneBook;
import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook
{

    private HashMap<String, Contact> phoneBook = new HashMap<>();

    public void addContact(String firstName, String lastName, String phoneNumber, String emailContact, String address)
    {
        Contact newContact = new Contact(firstName, lastName ,phoneNumber, emailContact, address);
        phoneBook.put(phoneNumber, newContact);
    }
    public Contact getContactByFirstName(HashMap<String, Contact> phoneBook,  String firstName)
    {
        ArrayList<Contact> contactFound = new ArrayList<>();
        for(Contact contact : phoneBook.values())
        {
            if(contact.getFirstName().equalsIgnoreCase(firstName))
            {
                contactFound.set(0,contact);
            }
        }
        return contactFound.get(0);

    }
    

}
