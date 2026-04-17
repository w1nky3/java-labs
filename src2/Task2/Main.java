package Task2;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Иван Иванов", "P-101", 1001, new int[]{5, 5, 4, 5, 4}),
                new Student("Петр Петров", "P-102", 1002, new int[]{3, 4, 4, 3, 4}),
                new Student("Анна Смирнова", "P-103", 1003, new int[]{5, 5, 5, 5, 5})
        };

        System.out.println("=== Информация о студентах ===");
        for (Student student : students) {
            student.printInfo();
            System.out.println("-------------------");
        }

        System.out.println("\n=== Меняем оценки у Петра ===");
        students[1].setGrades(new int[]{5, 5, 5, 4, 5});
        students[1].printInfo();

        System.out.println("\n=== Проверка ошибки ===");
        try {
            students[0].setGrades(new int[]{5, 6, 4, 5, 3});
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
