package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private ArrayList<Contact> contacts;

    public void addContact(Contact contact){
        if (contacts.contains(contact)){
            throw new IllegalArgumentException("Такой контакт уже существует");
        }

        contacts.add(contact);
    }

    public boolean removeContact(String phoneNumber){
        Contact contact = findByPhone(phoneNumber);
        
        if (contact != null){
            contacts.remove(contact);
            return true;
        }

        return false;
    }


    public List<Contact> findByName(String name){
        List<Contact> result = new ArrayList<>();

        if (name == null || name.isBlank()){
            return result;
        }

        String search = name.toLowerCase().trim();

        for (Contact contact : contacts){
            if (contact.getName().toLowerCase().contains(search)){
                result.add(contact);
            }
        }

        return result;
    }

    public Contact findByPhone(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isBlank()){
            return null;
        }

        String searchPhone = phoneNumber.trim();

        for (Contact contact : contacts){
            if (contact.getPhoneNumber().equals(searchPhone)){
                return contact;
            }
        }

        return null;
    }

   
}
