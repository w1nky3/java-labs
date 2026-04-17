package Task3;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("DE001", "Иван Иванов", 1000, 5);
        BankAccount acc2 = new BankAccount("DE002", "Петр Петров", 500, 3);

        System.out.println("=== Начальное состояние ===");
        acc1.printInfo();
        acc2.printInfo();

        System.out.println("\n=== Пополнение ===");
        acc1.deposit(200);
        acc1.printInfo();

        System.out.println("\n=== Снятие ===");
        acc1.withdraw(300);
        acc1.printInfo();

        System.out.println("\n=== Перевод ===");
        acc1.transfer(acc2, 400);
        acc1.printInfo();
        acc2.printInfo();

        System.out.println("\n=== Начисление процентов ===");
        acc2.applyInterest();
        acc2.printInfo();

        System.out.println("\n=== Проверка ошибок ===");
        try {
            acc1.withdraw(10000); // больше баланса
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            acc1.deposit(-50); // отрицательная сумма
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Закрытие счета ===");
        acc1.closeAccount();
        acc1.printInfo();

        System.out.println("\n=== Попытка операций после закрытия ===");
        try {
            acc1.deposit(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            acc1.withdraw(50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            acc1.applyInterest();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
