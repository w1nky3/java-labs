package task9;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String phone;
    private String address;

    private User(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirsName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private int age = 0;
        private String phone = null;
        private String address = null;

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setAge(int age){
            if (age < 0){
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            this.age = age;
            return this;
        }

        public Builder setPhone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public User build(){
            if (firstName == null || firstName.isBlank()){
                throw new IllegalStateException("firstName обязателен");
            }

            if (lastName == null || lastName.isBlank()){
                throw new IllegalStateException("lastName обязателен");
            }

            if (email == null || email.isBlank()){
                throw new IllegalStateException("email обязателен");
            }

            return new User(this);
        }
    }
}
