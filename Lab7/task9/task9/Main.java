package task9;

public class Main {
    public static void main(String[] args) {
        User user1 = new User.Builder()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setEmail("ivan@example.com")
                .setAge(20)
                .setPhone("+123456789")
                .setAddress("Moscow")
                .build();

        User user2 = new User.Builder()
                .setFirstName("Anna")
                .setLastName("Sidorova")
                .setEmail("anna@example.com")
                .build();

        System.out.println(user1);
        System.out.println(user2);

        try {
            User user3 = new User.Builder()
                    .setFirstName("NoEmail")
                    .setLastName("User")
                    .build();

            System.out.println(user3);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка создания пользователя: " + e.getMessage());
        }
    }
}
