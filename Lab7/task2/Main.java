package task2;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = Employee.createEmployee("Ivan Petrov", "IT", 75000, 2022);
        Employee employee2 = Employee.createEmployee("Anna Sidorova", "HR", 68000, 2021);
        Employee intern = Employee.createIntern("Pavel Smirnov", "IT");

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(intern);
    }
}
