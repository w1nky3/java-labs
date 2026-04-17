package task2;

import java.time.Year;

public class Employee {
    private int id;
    private String fullName;
    private String department;
    private double salary;
    private int hireYear;

    private static int nextId = 1;

    private Employee(int id, String fullName, String department, double salary, int hireYear){
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.hireYear = hireYear;
    }

    public static Employee createEmployee(String fullName, String department, double salary, int hireYear){
        if (fullName == null || fullName.isBlank()){
            throw new IllegalArgumentException("ФИО не может быть пустым");
        }

        if (department == null || department.isBlank()){
            throw new IllegalArgumentException("Отдел не может быть пустым");
        }

        if (salary <= 0){
            throw new IllegalArgumentException("Зарплата должна быть больше 0");
        }

        int currentYear = Year.now().getValue();
        if (hireYear > currentYear){
            throw new IllegalArgumentException("Год найма не может быть в будущем");
        }

        return new Employee(nextId++, fullName, department, salary, hireYear);
    }

    public static Employee createIntern(String fullName, String department){
        int currentYear = Year.now().getValue();
        return createEmployee(fullName, department, 30000, currentYear);
    }

    // Геттеры
    public int getId(){
        return id;
    }

    public String getFullName(){
        return fullName;
    }

    public String getDepartment(){
        return department;
    }

    public double getSalary(){
        return salary;
    }

    public int getHireYear(){
        return hireYear;
    }


    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", hireYear=" + hireYear +
                '}';
    }
}
