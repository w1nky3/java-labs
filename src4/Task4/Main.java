package src4.Task4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иван Иванов", "Разработчик", "IT", 85000,
                LocalDate.of(2020, 3, 10));
        Employee employee2 = new Employee("Анна Смирнова", "Тестировщик", "QA", 65000,
                LocalDate.of(2024, 1, 15), 5000);
        Employee employee3 = new Employee("Петр Петров", "Менеджер", "Sales", 120000,
                LocalDate.of(2018, 6, 1), 10000);

        System.out.println("=== Сотрудники ===");
        employee1.printInfo();
        System.out.println("-------------------");
        employee2.printInfo();
        System.out.println("-------------------");
        employee3.printInfo();

        System.out.println("\n=== Меняем надбавку ===");
        employee1.setBonus(7000);
        employee1.printInfo();

        System.out.println("\n=== Проверка ошибки ===");
        try {
            employee2.setSalary(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
