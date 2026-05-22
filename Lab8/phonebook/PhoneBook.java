import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class PhoneBook {
    private ArrayList<Contact> contactList = new ArrayList<>();

    public boolean addContact(Contact contact){
        if (contactList.contains(contact)){
            return false;
        }

        contactList.add(contact);
        return true;
    }

    public void removeContact(String phoneNumber){
        Contact contact = findByPhone(phoneNumber);

        if (contact != null){
            contactList.remove(contact);
        }
    }

    public Contact findByPhone(String phoneNumber){
        for (Contact contact : contactList){
            if (contact.getPhoneNumber().equals(phoneNumber)){
                return contact;
            }
        }

        return null;
    }

    public ArrayList<Contact> findByName(String name){
        ArrayList<Contact> correctNames = new ArrayList<>();

        for (Contact contact : contactList){
            if (contact.getName().toLowerCase().contains(name.toLowerCase())){
                correctNames.add(contact);
            }
        }

        return correctNames;
    }

    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> sortedList = new ArrayList<>(contactList);

        sortedList.sort(Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));

        return sortedList;
    }

    public void saveToFile(String fileName){
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(fileName)))) {
            for (Contact contact : contactList){
                String emailPart = (contact.getEmail() == null || contact.getEmail().isBlank()) ? "" : contact.getEmail();
                writer.write(contact.getName() + "|" + contact.getPhoneNumber() + "|" + emailPart);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) throws IOException{
        try (BufferedReader reader = new BufferedReader(((new FileReader(fileName))))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] lineParts = line.split("\\|", -1);
                Contact contact = new Contact(lineParts[0], lineParts[1], lineParts[2]);
                addContact(contact);
            }
        }
    }
}
