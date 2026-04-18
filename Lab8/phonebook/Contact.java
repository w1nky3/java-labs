package phonebook;

import java.util.Objects;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    // Геттер и сеттер для name
    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }

        this.name = name;
    }

    public String getName(){
        return name;
    }

    // Геттер и сеттер для phoneNumber
    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Номер телефона не должен быть пустым");
        }

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    // Геттер и сеттер для email
    public void setEmail(String email){
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("Email не может быть пуст");
        }

        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    
    @Override
    public String toString(){
        if (email == null || email.isBlank()){
            return name + ": " + phoneNumber;
        }

        return name + ": " + phoneNumber + ", " + email;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) { return true; }

        if (!(o instanceof Contact)) { return false; }

        Contact contact = (Contact)o;
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode(){
        return Objects.hash(phoneNumber);
    }
}


