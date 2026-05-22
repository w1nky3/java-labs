import java.util.Objects;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        
        setName(name);
        setPhoneNumber(phoneNumber);
        this.email = email;
    }

    //Геттер и сеттер для name
    public String getName(){
        return name;
    }

    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }

        this.name = name;
    }

    //Геттер и сеттер для phoneNumber
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Телефон не должен быть пустым");
        }

        this.phoneNumber = phoneNumber;
    }

    //Геттер и сеттер для email
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

   @Override
   public String toString() {
        String emailPart = (email == null || email.isBlank()) ? "" : ", " + email;
        return name + ": " + phoneNumber + emailPart;
   }

   @Override
   public boolean equals(Object obj) {
       if (this == obj){
            return true;
       }

       if (obj == null || getClass() != obj.getClass()){
            return false;
       }

       Contact contact = (Contact)obj;

       return Objects.equals(this.phoneNumber, contact.phoneNumber);
   }

   @Override
   public int hashCode() {
       return Objects.hash(phoneNumber);
   }
}
