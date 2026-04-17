package task6;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Один и тот же объект? " + (db1 == db2));
        System.out.println("hashCode db1: " + db1.hashCode());
        System.out.println("hashCode db2: " + db2.hashCode());

        db1.connect();
        db1.executeQuery("SELECT * FROM users");
        db1.disconnect();

        DatabaseConnection.configure("jdbc:mysql://localhost:3306/test", "root", "1234");

        db2.connect();
        db2.executeQuery("UPDATE users SET name = 'Alex' WHERE id = 1");
        db2.disconnect();
    }
}
